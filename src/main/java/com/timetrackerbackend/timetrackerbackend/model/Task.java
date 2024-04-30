package com.timetrackerbackend.timetrackerbackend.model;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private String taskName;
    private List<Time> times = new ArrayList<>();
    
    public Task(String taskName, List<Time> times) {
        this.taskName = taskName;
        this.times = times;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }
    
    
}
