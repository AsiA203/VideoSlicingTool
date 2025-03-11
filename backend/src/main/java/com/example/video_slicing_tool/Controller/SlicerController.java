package com.example.video_slicing_tool.Controller;

import com.example.video_slicing_tool.Service.SlicerService;
import com.example.video_slicing_tool.model.VideoSlice;

import java.util.List;

public class SlicerController {
    SlicerService slicerService;

    public SlicerController() {
        this.slicerService = new SlicerService();
    }

    //@POST
    public void sliceVideo(String originalVideoPath, VideoSlice videoSlice, String outputSavePath) throws InterruptedException {
        slicerService.sliceVideo(originalVideoPath, videoSlice, outputSavePath);
    }

    //@POST
    public void severalSlicesVideo(String originalVideoPath, List<VideoSlice> videoSlice, String outputSavePath) throws InterruptedException {
        slicerService.manySliceVideo(originalVideoPath, videoSlice, outputSavePath);
    }
}
