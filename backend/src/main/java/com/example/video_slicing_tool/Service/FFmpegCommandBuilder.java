package com.example.video_slicing_tool.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FFmpegCommandBuilder {
    private final List<String> command;
    double sliceBeginning;
    double sliceEnd;

    public FFmpegCommandBuilder() {
        this.command = new ArrayList<>();
        command.add("ffmpeg");
    }

    public FFmpegCommandBuilder i(String originalVideo) {
        command.add("-i");
        command.add(originalVideo.strip());
        return this;
    }

    public FFmpegCommandBuilder ss(String sliceBeginning) {
        this.sliceBeginning = timeToSeconds(sliceBeginning);
        command.add("-ss");
        command.add(sliceBeginning.strip());
        return this;
    }

    public FFmpegCommandBuilder to(String sliceEnd) {
        this.sliceEnd = timeToSeconds(sliceEnd);
        command.add("-to");
        command.add(sliceEnd.strip());
        return this;
    }

    /* copies original's videos codec, no re-encoding, fast, NOT EXACT KEYFRAMES, MAY MISS KEYFRAMES */
    public FFmpegCommandBuilder copy(String codec) {
        command.add("-c");
        command.add("copy");
        return this;
    }

    /* copies original's videos codec, no re-encoding, fast, INCLUDES FIRST KEYFRAMES, STILL not exact keyframes after*/
    public FFmpegCommandBuilder copyinkf() {
        command.add("-c");
        command.add("copy");
        command.add("-copyinkf");
        return this;
    }

    /* re-encodes, slow, exact frame keyframes, can modify bitrate, resolution and format */
    public FFmpegCommandBuilder codec(String codec) {
        command.add("-c:v");
        command.add(codec.strip());
        return this;
    }

    /* saves ready slice to the provided path*/
    public FFmpegCommandBuilder outputSave(String path) {
        command.add("-y");
        command.add(path.strip());
        return this;
    }

    public List<String> build() {
        System.out.println(command);
        return command;
    }

    public void execute(List<String> command) {
        try {
            double sliceDuration = sliceEnd - sliceBeginning;

            ProcessBuilder builder = new ProcessBuilder(command); //for the command line
            builder.redirectErrorStream(true); //gets all logs
            Process process = builder.start(); //starts the command (pressing Enter)

            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("time=")) {
                    System.out.println(getSliceProgress(line, sliceDuration));
                } else if (line.contains("error") || line.contains("failed")) {
                    System.out.println("ERROR: " + line);
                }
            }

            int status = process.waitFor();
            if (status == 0) {
                System.out.println("Request is completed");
            } else {
                System.out.println("Request failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Helpers
    public String getSliceProgress(String line, double sliceDuration) {
        int start = line.indexOf("time=") + 5;
        String getTimeLine = line.substring(start, start + 11); //00:00:00:00 (11)
        double processedSeconds = timeToSeconds(getTimeLine);

        double progress = ((processedSeconds - sliceBeginning) / sliceDuration) * 100;
        int progressIn100 = Math.max(0, Math.min(100, (int) progress));
        return "Progress: " + progressIn100 + "% (" + getTimeLine + ")";
    }

    public double timeToSeconds(String time) {
        String [] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]) * 3600;
        int minutes = Integer.parseInt(parts[1]) * 60;
        double seconds = Double.parseDouble(parts[2]);
        return hours + minutes + seconds;
    }
}