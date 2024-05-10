package com.timetrackerbackend.timetrackerbackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.timetrackerbackend.timetrackerbackend.config.UserAuthenticationProvider;
import com.timetrackerbackend.timetrackerbackend.dtos.CredentialsDto;
import com.timetrackerbackend.timetrackerbackend.dtos.SignUpDto;
import com.timetrackerbackend.timetrackerbackend.dtos.TaskDto;
import com.timetrackerbackend.timetrackerbackend.dtos.UserDto;
import com.timetrackerbackend.timetrackerbackend.model.Task;
import com.timetrackerbackend.timetrackerbackend.model.User;
import com.timetrackerbackend.timetrackerbackend.services.TaskService;
import com.timetrackerbackend.timetrackerbackend.services.UserService;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;
    

    
    

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) {
        UserDto createdUser = userService.register(user);
        createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }
    

}
