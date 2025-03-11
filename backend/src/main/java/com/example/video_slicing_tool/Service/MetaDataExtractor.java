package com.example.video_slicing_tool.Service;

import java.nio.file.Paths;

public class MetaDataExtractor {
    protected String format;
    protected double duration;
    protected long bitRate;
    
    String ffprobePath = "/usr/bin/ffprobe";

    //TODO
    public void getMetaDataFromVideo(String filePath) {
    }
}
