package com.timetrackerbackend.timetrackerbackend.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public class Time {
    @Id
    private String id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long elapsedTime;

    public Time(String id, LocalDateTime startTime, LocalDateTime endTime, long elapsedTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.elapsedTime = elapsedTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
    
    
   
    
    
}
