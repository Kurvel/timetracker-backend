package com.timetrackerbackend.timetrackerbackend.services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.timetrackerbackend.timetrackerbackend.model.Task;
import com.timetrackerbackend.timetrackerbackend.model.User;

@Service
public class TaskService {

    private UserRepository userRepository;
    

    public TaskService(UserRepository userRepository) {
        this.userRepository = userRepository;
       
    }

    private String generateUniqueId() {

        return UUID.randomUUID().toString();
    }

    public Task getTask(String userId, String taskId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            Optional<Task> optionalTask = user.getTasks().stream()
                    .filter(task -> {
                        String taskID = task.getId();
                        return taskID != null && taskID.equals(taskId);
                    })
                    .findFirst();
            if (optionalTask.isPresent()) {
                return optionalTask.get();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public User addTask(Task task, String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String taskId = generateUniqueId();
            task.setId(taskId);
            user.getTasks().add(task);
            userRepository.save(user);
            return user;
        } else {
            return null;
        }
    }

    public Task editTask(String userId, String taskId, Task updatedTask) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            List<Task> tasks = user.getTasks();
            for (Task task : tasks) {
                String taskID = task.getId();
                if (taskID != null && taskID.equals(taskId)) {
                    
                    task.setTaskName(updatedTask.getTaskName());
                    
                    userRepository.save(user);
                    return task; 
                }
            }
        }
        return null; 
    }

    public Task deleteTask(String userId, String taskId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            List<Task> tasks = user.getTasks();
            Iterator<Task> iterator = tasks.iterator();
            while (iterator.hasNext()) {
                Task task = iterator.next();
                String taskID = task.getId();
                if (taskID != null && taskID.equals(taskId)) {
                    iterator.remove();
                    userRepository.save(user);
                    return task;
                }
            }
        }
        return null;
    }

}
