package com.example.backend_challenge.Controllers;

import com.example.backend_challenge.Dtos.LoginRequestDto;
import com.example.backend_challenge.Dtos.UserDto;
import com.example.backend_challenge.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequest) {
        UserDto userDto = userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
        if (userDto != null) {
            return ResponseEntity.ok(userDto);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}