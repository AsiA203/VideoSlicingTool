package com.example.video_slicing_tool.model;

import com.example.video_slicing_tool.Enum.VideoFormat;
import com.example.video_slicing_tool.Enum.VideoQuality;

public class VideoSlice {
    private String sliceBeginning;
    private String sliceEnd;
    private VideoFormat videoFormat;
    private VideoQuality videoQuality;
    //TODO add slice metadata

    public VideoSlice() {}

    public VideoSlice(String sliceBeginning, String sliceEnd) {
        this.sliceBeginning = sliceBeginning;
        this.sliceEnd = sliceEnd;
    }

    public VideoSlice(String sliceBeginning,
                      String sliceEnd, VideoFormat videoFormat, VideoQuality videoQuality) {
        this.sliceBeginning = sliceBeginning;
        this.sliceEnd = sliceEnd;
        this.videoFormat = videoFormat;
        this.videoQuality = videoQuality;
    }

    public String getSliceBeginning() {
        return sliceBeginning;
    }

    public void setSliceBeginning(String sliceBeginning) {
        this.sliceBeginning = sliceBeginning;
    }

    public String getSliceEnd() {
        return sliceEnd;
    }

    public void setSliceEnd(String sliceEnd) {
        this.sliceEnd = sliceEnd;
    }

    public VideoFormat getVideoFormat() {
        return videoFormat;
    }

    public void setVideoFormat(VideoFormat videoFormat) {
        this.videoFormat = videoFormat;
    }

    public VideoQuality getVideoQuality() {
        return videoQuality;
    }

    public void setVideoQuality(VideoQuality videoQuality) {
        this.videoQuality = videoQuality;
    }
}