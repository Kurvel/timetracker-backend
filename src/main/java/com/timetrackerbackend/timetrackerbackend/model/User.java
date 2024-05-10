package com.timetrackerbackend.timetrackerbackend.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.timetrackerbackend.timetrackerbackend.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "Users")
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String password;
    private String login;
    private List<Task> tasks = new ArrayList<>();
    
    private Role role;

    
    
    

 
   

   
    
    
    

    
    
}
