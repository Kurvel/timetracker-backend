package com.timetrackerbackend.timetrackerbackend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.timetrackerbackend.timetrackerbackend.model.User;

import com.timetrackerbackend.timetrackerbackend.services.UserService;


@RestController
public class UserController {
    private UserService userService;
    

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRoot() {
        return "{'Hello': 'World!'}";
    }

    @GetMapping("/test")
    public ResponseEntity<List<String>> test() {
        return ResponseEntity.ok(Arrays.asList("first", "second"));
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }
    
    // @PostMapping("/user")
    // public User addUser(@RequestBody User user) {
    //     return userService.addUser(user);
    // }

    // @PostMapping("/user")
    // public ResponseEntity<?> addUser(@RequestBody User user) {

    //     return userService.addUser(user);
    // }

    @PatchMapping("/user/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User editUser(@PathVariable String id, @RequestBody User user) {
        return userService.editUser(id, user);
    }

    @DeleteMapping("/user/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "Deleted " + id;
    }
}
