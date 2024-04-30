package com.timetrackerbackend.timetrackerbackend.model;

import java.time.LocalDateTime;

public class Time {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime elapsedTime;
    
    public Time(LocalDateTime startTime, LocalDateTime endTime, LocalDateTime elapsedTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.elapsedTime = elapsedTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(LocalDateTime elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
    
}
