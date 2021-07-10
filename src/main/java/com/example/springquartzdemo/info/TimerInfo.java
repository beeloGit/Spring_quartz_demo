package com.example.springquartzdemo.info;

public class TimerInfo {
    private int totalFireCount;
    private boolean runForever;
    private Long repeatIntervalMs;
    private  Long initialOffsetMs;
    private String callbackData;

    public TimerInfo(int totalFireCount, boolean runForever, Long repeatIntervalMs, Long initialOffsetMs, String callbackData) {
        this.totalFireCount = totalFireCount;
        this.runForever = runForever;
        this.repeatIntervalMs = repeatIntervalMs;
        this.initialOffsetMs = initialOffsetMs;
        this.callbackData = callbackData;
    }

    public TimerInfo() {

    }

    public int getTotalFireCount() {
        return totalFireCount;
    }

    public void setTotalFireCount(int totalFireCount) {
        this.totalFireCount = totalFireCount;
    }

    public boolean isRunForever() {
        return runForever;
    }

    public void setRunForever(boolean runForever) {
        this.runForever = runForever;
    }

    public Long getRepeatIntervalMs() {
        return repeatIntervalMs;
    }

    public void setRepeatIntervalMs(Long repeatIntervalMs) {
        this.repeatIntervalMs = repeatIntervalMs;
    }

    public Long getInitialOffsetMs() {
        return initialOffsetMs;
    }

    public void setInitialOffsetMs(Long initialOffsetMs) {
        this.initialOffsetMs = initialOffsetMs;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public void setCallbackData(String callbackData) {
        this.callbackData = callbackData;
    }
}
