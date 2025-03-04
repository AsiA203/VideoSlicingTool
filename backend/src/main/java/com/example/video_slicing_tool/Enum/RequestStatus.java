package com.example.video_slicing_tool.Enum;

public enum RequestStatus {
    IN_PROGRESS("Slicing is in progress. Please wait."),
    COMPLETED("Slicing has been completed. Please follow provided links."),
    FAILED("Slicing failed. Please try again.");

    private final String status;

    RequestStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
