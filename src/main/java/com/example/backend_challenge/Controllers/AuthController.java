package com.example.backend_challenge.Controllers;


import com.example.backend_challenge.Services.AuthService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@NoArgsConstructor
public class AuthController {


    public AuthService authService;


    PostMapping("/register")
        ResponseEntity  register(@RequestBody RegisterRequest registerRequest) {

        }

    PostMapping("/login")


}
