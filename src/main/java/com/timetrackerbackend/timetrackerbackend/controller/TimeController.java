package com.timetrackerbackend.timetrackerbackend.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.timetrackerbackend.timetrackerbackend.model.Time;

import com.timetrackerbackend.timetrackerbackend.services.TimeService;

@RestController
public class TimeController {
    
    private TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("user/{id}/task/{taskId}/time/{timeId}")
    public Time getTime(@PathVariable String id, @PathVariable String taskId, @PathVariable String timeId ) {
        return timeService.getTime(id, taskId, timeId);
    }
    
    @PostMapping("user/{id}/task/{taskId}/time")
    public Time addTime(@RequestBody Time time, @PathVariable String id, @PathVariable String taskId) {
        return timeService.addTime(id, taskId, time);
    }

    @PatchMapping("user/{id}/task/{taskId}/time/{timeId}")
    public Time editTime(@RequestBody Time time, @PathVariable String id, @PathVariable String taskId, @PathVariable String timeId) {
        return timeService.editTime(id, taskId, timeId, time);
    }

    @DeleteMapping("user/{id}/task/{taskId}/time/{timeId}")
    public Time deleteTime(@PathVariable String id, @PathVariable String taskId, @PathVariable String timeId) {
        return timeService.deleteTime(id, taskId, timeId);
    }

}
