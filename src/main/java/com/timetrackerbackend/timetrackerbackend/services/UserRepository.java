package com.timetrackerbackend.timetrackerbackend.services;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.timetrackerbackend.timetrackerbackend.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    
    
   
    
    boolean existsByFirstName(String firstName);
    Optional<User> findByLogin(String login);
}
