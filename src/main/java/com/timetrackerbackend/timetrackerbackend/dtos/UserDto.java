package com.timetrackerbackend.timetrackerbackend.dtos;

import com.timetrackerbackend.timetrackerbackend.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String id;
    private String firstName;
    private String lastName;
    private String login;
    private String token;
    private Role role;

}