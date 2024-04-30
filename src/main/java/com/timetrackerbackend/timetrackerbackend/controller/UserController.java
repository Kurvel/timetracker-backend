package com.timetrackerbackend.timetrackerbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
}