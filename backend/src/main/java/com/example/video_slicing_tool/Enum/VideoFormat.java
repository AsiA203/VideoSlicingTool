package com.example.video_slicing_tool.Enum;

public enum VideoFormat {
    MP4("mp4"), /*MPEG-4 Part 14*/
    MOV("mov"), /*QuickTime Movie, Apple*/
    AVI("avi"), /*Audio Video Interleave*/
    WMV("wmv"), /*Windows Media Video*/
    MKV("mkv"); /*Matroska Multimedia Container*/

    private final String format;

    VideoFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
