package com.example.video_slicing_tool.Service;

import com.example.video_slicing_tool.Enum.OriginalVideoStatus;
import com.example.video_slicing_tool.model.SliceResult;
import com.example.video_slicing_tool.model.Video;
import com.example.video_slicing_tool.model.VideoSlice;

import java.io.File;
import java.util.List;

public class Slicer {
    private Video video;
    private List<VideoSlice> videoSlices;
    private List<SliceResult> sliceResults;

    public Slicer(Video video, List<VideoSlice> videoSlices, List<SliceResult> sliceResults) {
        this.video = video;
        this.videoSlices = videoSlices;
        this.sliceResults = sliceResults;
    }

    //Get original video, just on local for now
    public OriginalVideoStatus getOriginalVideo(String path) {
        if (path.length() == 0) {
            return OriginalVideoStatus.EMPTY_PATH;
        }

        /*TODO later should be reused for checking if video exist on local machine after downloading from cloud */
        if (fileExist(path)) {
            Video video = new Video(path, );
        }
        return null;
    }

    //TODO download original video from AWS S3
    public void getOriginalVideoFromAWS_S3(String path) {};

    //Helpers

    //Check if file exists
    public boolean fileExist(String path) {
        File file = new File(path);
        return file.exists();
    }
}
