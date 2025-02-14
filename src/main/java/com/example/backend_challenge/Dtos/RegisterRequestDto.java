package com.example.backend_challenge.Dtos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
    String email;
    String username;
    String password;
    String name;
    String lastName;
}
