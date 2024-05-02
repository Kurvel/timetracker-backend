package com.timetrackerbackend.timetrackerbackend.services;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.timetrackerbackend.timetrackerbackend.model.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
    
}
