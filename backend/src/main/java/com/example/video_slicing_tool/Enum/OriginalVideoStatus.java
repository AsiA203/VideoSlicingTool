package com.example.video_slicing_tool.Enum;

public enum OriginalVideoStatus {
    DOWNLOADING("Video is downloading, please wait."),
    COMPLETED("Downloaded"),
    FAILED("Download has failed. Please try again"),
    INCORRECT_PATH("Provided link is incorrect, please check and try again."),
    WAS_NOT_ABLE_TO_FIND_AT_PATH("Video is not found on path: "),
    EMPTY_PATH("No link was provided");

    private final String status;

    OriginalVideoStatus(String status) {
        this.status = status;
    }

    public String getStatus(String status) {
        return status;
    }
}
