package com.timetrackerbackend.timetrackerbackend.services;

import java.util.List;
import java.util.Optional;

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

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
    
}
