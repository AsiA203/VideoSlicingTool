package com.example.video_slicing_tool.model;

public class VideoSlice {
    private String pathToOriginalVideo;
    private String sliceBeginning;
    private String sliceEnd;
    private String videoType;
    private String videoQuality;

    public VideoSlice(String pathToOriginalVideo, String sliceBeginning, String sliceEnd) {
        this.pathToOriginalVideo = pathToOriginalVideo;
        this.sliceBeginning = sliceBeginning;
        this.sliceEnd = sliceEnd;
    }

    public VideoSlice(String pathToOriginalVideo, String sliceBeginning, String sliceEnd, String videoType, String videoQuality) {
        this.pathToOriginalVideo = pathToOriginalVideo;
        this.sliceBeginning = sliceBeginning;
        this.sliceEnd = sliceEnd;
        this.videoType = videoType;
        this.videoQuality = videoQuality;
    }

    public String getPathToOriginalVideo() {
        return pathToOriginalVideo;
    }

    public void setPathToOriginalVideo(String pathToOriginalVideo) {
        this.pathToOriginalVideo = pathToOriginalVideo;
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

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getVideoQuality() {
        return videoQuality;
    }

    public void setVideoQuality(String videoQuality) {
        this.videoQuality = videoQuality;
    }
}
