package com.example.video_slicing_tool.model;

public class Video {
    private String path;
    private String format;

    public Video(String path, String format) {
        this.path = path;
        this.format = format;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}