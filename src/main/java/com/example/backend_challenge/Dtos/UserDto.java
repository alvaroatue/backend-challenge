package com.example.backend_challenge.Dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    long id;
    String email;
    String password;
    String Name;
    String lastName;
}
