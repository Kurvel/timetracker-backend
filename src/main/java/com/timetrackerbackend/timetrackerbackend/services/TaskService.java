package com.timetrackerbackend.timetrackerbackend.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.timetrackerbackend.timetrackerbackend.model.Task;
import com.timetrackerbackend.timetrackerbackend.model.User;



@Service
public class TaskService {
    
    private UserRepository userRepository;
    private TaskRepository taskRepository;

    public TaskService(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    public User addTask(Task task, String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            task.setId(null);
            Task savedTask = taskRepository.save(task);
            user.getTasks().add(savedTask);
            userRepository.save(user);
            return user;
        } else return null;
    }
}
