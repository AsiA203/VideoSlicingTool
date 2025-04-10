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
    public void singleSlice(String originalVideoName, VideoSlice videoSlice, int slicingMode, String outputFileName) throws InterruptedException {
        slicerService.singleSlice(originalVideoName, videoSlice, slicingMode, outputFileName);
    }

    //@POST
    public void manySlices(String originalVideoName, List<VideoSlice> videoSlices, int slicingMode, String outputFileName) throws InterruptedException {
        slicerService.manySlices(originalVideoName, videoSlices, slicingMode, outputFileName);
    }
}
