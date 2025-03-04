package com.example.video_slicing_tool.model;

public class SliceResult {
    private String path;
    private String format;
    private String timestamp;

    public SliceResult(String path, String format, String timestamp) {
        this.path = path;
        this.format = format;
        this.timestamp = timestamp;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}