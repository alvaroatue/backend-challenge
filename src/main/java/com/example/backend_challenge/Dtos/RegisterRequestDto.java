package com.example.backend_challenge.Dtos;

import lombok.Data;

@Data
public class RegisterRequestDto {
    String email;
    String password;
    String name;
    String lastName;
}
