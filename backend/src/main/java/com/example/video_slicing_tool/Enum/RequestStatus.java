package com.example.video_slicing_tool.Enum;

public enum RequestStatus {
    IN_PROGRESS("Slicing is in progress. Please wait."),
    COMPLETED("Slicing has been completed. Please follow provided links."),
    FAILED("Slicing failed. Please try again.");

    private final String message;

    RequestStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
