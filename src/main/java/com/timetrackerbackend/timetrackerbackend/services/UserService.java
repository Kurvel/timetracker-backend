package com.timetrackerbackend.timetrackerbackend.services;

import org.springframework.stereotype.Service;

import com.timetrackerbackend.timetrackerbackend.model.User;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User addUser(User user) {
        return userRepository.insert(user);
    }
    
}
