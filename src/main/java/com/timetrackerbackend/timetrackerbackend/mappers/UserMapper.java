package com.timetrackerbackend.timetrackerbackend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.timetrackerbackend.timetrackerbackend.dtos.SignUpDto;
import com.timetrackerbackend.timetrackerbackend.dtos.UserDto;
import com.timetrackerbackend.timetrackerbackend.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
