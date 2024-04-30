package com.timetrackerbackend.timetrackerbackend.services;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.timetrackerbackend.timetrackerbackend.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    
}
