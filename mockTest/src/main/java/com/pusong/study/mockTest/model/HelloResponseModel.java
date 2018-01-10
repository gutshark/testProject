package com.pusong.study.mockTest.model;

public class HelloResponseModel {
    private String message;
    private long timestamp;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public HelloResponseModel() {
        timestamp = System.currentTimeMillis();
    }
}
