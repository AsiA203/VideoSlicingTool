package com.example.video_slicing_tool.Service;

import com.example.video_slicing_tool.Enum.OriginalVideoStatus;
import com.example.video_slicing_tool.model.SliceResult;
import com.example.video_slicing_tool.model.Video;
import com.example.video_slicing_tool.model.VideoSlice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SlicerService {
    private List<SliceResult> sliceResults;

    private final String userHome = System.getProperty("user.home");
    private final String inputPath = userHome + "/Desktop/videoSlicingTool/input/";
    private final String outputPath = userHome + "/Desktop/videoSlicingTool/output/";

    public SlicerService() {
        this.sliceResults = new ArrayList<>();
    }

    public void manySliceVideo(String originalVideoName, List<VideoSlice> videoSlices, String outputSaveName) throws InterruptedException {
        for (int i = 0; i < videoSlices.size(); i++) {
            System.out.println("\nSlice #" + (i + 1) + " is in progress.");
            sliceVideo(originalVideoName, videoSlices.get(i), (i + 1) + outputSaveName);
        }
    }

    public void sliceVideo(String originalVideoName, VideoSlice videoSlice, String outputSaveName) throws InterruptedException {
        System.out.println(getOriginalVideo(originalVideoName));

        FFmpegCommandBuilder ffmpegCommandBuilder = new FFmpegCommandBuilder();
        List<String> command = ffmpegCommandBuilder
                .ss(videoSlice.getSliceBeginning())
                .to(videoSlice.getSliceEnd())
                .i(inputPath + originalVideoName.strip())
                .copyinkf()
                .outputSave(outputPath + outputSaveName.strip())
                .build();
        ffmpegCommandBuilder.execute(command);

        Thread.sleep(20000);
        if (fileExist(outputPath + outputSaveName)) {
            System.out.println("Slice is saved at path: " + outputPath + outputSaveName);
        }
    }

    //Get original video, just on local for now
    public boolean getOriginalVideo(String path) {
        if (path.length() == 0) {
            System.out.println(OriginalVideoStatus.EMPTY_PATH);
            return false;
        }

        /*TODO later should be reused for checking if video exist on local machine after downloading from cloud */
        if (!fileExist(inputPath + path)) {
            System.out.println(OriginalVideoStatus.WAS_NOT_ABLE_TO_FIND_AT_PATH + path);
            return false;
        }
        return true;
    }

    //TODO download original video from AWS S3
    public void getOriginalVideoFromAWS_S3(String path) {
    }

    ;

    /* Helpers */
    //Checks if file exists
    public boolean fileExist(String path) {
        File file = new File(path);
        return file.exists();
    }
}