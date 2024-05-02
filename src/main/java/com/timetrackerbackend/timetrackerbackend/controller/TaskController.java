package com.timetrackerbackend.timetrackerbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.timetrackerbackend.timetrackerbackend.model.Task;
import com.timetrackerbackend.timetrackerbackend.model.User;
import com.timetrackerbackend.timetrackerbackend.services.TaskService;

@RestController
public class TaskController {

    private TaskService taskService;

    
    
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("task/{taskId}")
    public Task getTask(@PathVariable String taskId ) {
        return taskService.getTask(taskId);
    }

    @PostMapping("/user/{id}/task")
    public User addTask(@RequestBody Task task, @PathVariable String id) {
        return taskService.addTask(task, id);
    }
}
