package com.example.video_slicing_tool.Service;

import com.github.kokorin.jaffree.ffprobe.FFprobe;

import java.nio.file.Paths;

public class MetaDataExtractor {
    protected String format;
    protected double duration;
    protected long bitRate;

    String ffprobePath = "/usr/bin/ffprobe";
    FFprobe ffprobe = new FFprobe(Paths.get(ffprobePath));

    public void getMetaDataFromVideo(String path) {

    }
}
