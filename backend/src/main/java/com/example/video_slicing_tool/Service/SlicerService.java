package com.example.video_slicing_tool.Service;

import com.example.video_slicing_tool.Enum.OriginalVideoStatus;
import com.example.video_slicing_tool.model.SliceResult;
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

    public void manySlices(String originalVideoName, List<VideoSlice> videoSlices, int slicingMode, String outputSaveName) throws InterruptedException {
        for (int i = 0; i < videoSlices.size(); i++) {
            System.out.println("\nSlice #" + (i + 1) + " is in progress.");
            singleSlice(originalVideoName, videoSlices.get(i),
                    slicingMode, outputSaveName + "__" + (i + 1));
        }
    }

    public void singleSlice(String originalVideoName, VideoSlice videoSlice, int slicingMode, String outputSaveName) throws InterruptedException {
        if (originalVideoName == null || originalVideoName.length() == 0) {
//            throw OriginalVideoStatus.EMPTY_PATH;
        }
        System.out.println(checkIfFileExists(originalVideoName));

//        FFmpegCommandBuilder ffmpegCommandBuilder = new FFmpegCommandBuilder();
//        List<String> command = ffmpegCommandBuilder
//                .ss(videoSlice.getSliceBeginning())
//                .to(videoSlice.getSliceEnd())
//                .i(inputPath + originalVideoName.strip())
//                switch (slicingMode) {
//                    case 1: .copy();
//                }
//                .copyinkf()
//                .outputSave(outputPath + outputSaveName.strip())
//                .build();
//        ffmpegCommandBuilder.execute(command);

        Thread.sleep(20000);
        if (fileExist(outputPath + outputSaveName)) {
            System.out.println("Slice is saved at path: " + outputPath + outputSaveName);
        }
    }

    //Check if original video exists, just on local for now
    public boolean checkIfFileExists(String fileName) {
        if (fileName == null || fileName.length() == 0) {
            System.out.println(OriginalVideoStatus.EMPTY_PATH);
            return false;
        }

        /*TODO later should be reused for checking if video exist on local machine after downloading from cloud */
        if (!fileExist(inputPath + fileName)) {
            System.out.println(OriginalVideoStatus.WAS_NOT_ABLE_TO_FIND_AT_PATH + inputPath + fileName);
            return false;
        }
        return true;
    }

    //TODO download original video from AWS S3
    public void getOriginalVideoFromAWS_S3(String fileName) {}

    /* Helpers */
    //Checks if file exists
    public boolean fileExist(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    //Get the file extension
    public OriginalVideoStatus getFileExtension(String fileName) {
        if (fileName == null || fileName.length() == 0) return OriginalVideoStatus.EMPTY_PATH;


    }
}