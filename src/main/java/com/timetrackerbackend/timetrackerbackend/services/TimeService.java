package com.timetrackerbackend.timetrackerbackend.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.timetrackerbackend.timetrackerbackend.model.Task;
import com.timetrackerbackend.timetrackerbackend.model.Time;
import com.timetrackerbackend.timetrackerbackend.model.User;

@Service
public class TimeService {
    
    private UserRepository userRepository;

    public TimeService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    private String generateUniqueId() {

        return UUID.randomUUID().toString();
    }

    public Time addTime(String userId, String taskId, Time time) {
    Optional<User> optionalUser = userRepository.findById(userId);
    if (optionalUser.isPresent()) {
        User user = optionalUser.get();
       
        Optional<Task> optionalTask = user.getTasks().stream()
            .filter(task -> {
                String taskIdOfTask = task.getId();
                return taskIdOfTask != null && taskIdOfTask.equals(taskId);
            })
            .findFirst();
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            
            if (task.getTimes() == null) {
                task.setTimes(new ArrayList<>());
            }
            
            String timeId = generateUniqueId();
            time.setId(timeId);
            task.getTimes().add(time);
            
            userRepository.save(user);
            return time; 
        }
    }
    return null; 
}
public Time getTime(String userId, String taskId, String timeId) {
    Optional<User> optionalUser = userRepository.findById(userId);
    if (optionalUser.isPresent()) {
        User user = optionalUser.get();
        Optional<Task> optionalTask = user.getTasks().stream()
            .filter(task -> {
                String taskIdOfTask = task.getId();
                return taskIdOfTask != null && taskIdOfTask.equals(taskId);
            })
            .findFirst();
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            Optional<Time> optionalTime = task.getTimes().stream()
                .filter(time -> {
                    String timeIdOfTime = time.getId();
                    return timeIdOfTime != null && timeIdOfTime.equals(timeId);
                })
                
                
                .findFirst();
            if (optionalTime.isPresent()) {
                return optionalTime.get(); 
            }
        }
    }
    return null; 
}

public Time editTime(String userId, String taskId, String timeId, Time updatedTime) {
    Optional<User> optionalUser = userRepository.findById(userId);
    if (optionalUser.isPresent()) {
        User user = optionalUser.get();
        List<Task> tasks = user.getTasks();
        for (Task task : tasks) {
            String taskID = task.getId();
            if (taskID != null && taskID.equals(taskId)) {
                List<Time> times = task.getTimes();
                for (Time time : times) {
                    String timeID = time.getId();
                    if (timeID != null && timeID.equals(timeId)) {
                        time.setElapsedTime(updatedTime.getElapsedTime());
                        userRepository.save(user);
                        return time;
                    }
                }
            }
        }
    }
    return null; 
}

public Time deleteTime(String userId, String taskId, String timeId) {
    Optional<User> optionalUser = userRepository.findById(userId);
    if (optionalUser.isPresent()) {
        User user = optionalUser.get();
        List<Task> tasks = user.getTasks();
        for (Task task : tasks) {
            String taskID = task.getId();
            if (taskID != null && taskID.equals(taskId)) {
                List<Time> times = task.getTimes();
                Iterator<Time> iterator = times.iterator();
                while (iterator.hasNext()) {
                    Time time = iterator.next();
                    String timeID = time.getId();
                    if (timeID != null && timeID.equals(timeId)) {
                        iterator.remove(); 
                        userRepository.save(user); 
                        return time;
                    }
                }
            }
        }
    }
    return null;
}



    
    
}
