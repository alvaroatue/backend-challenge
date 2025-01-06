package com.example.backend_challenge.Controllers;


import com.example.backend_challenge.Dtos.TokenResponse;
import com.example.backend_challenge.Dtos.LoginRequestDto;
import com.example.backend_challenge.Dtos.RegisterRequestDto;
import com.example.backend_challenge.Services.AuthService;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor

public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<TokenResponse> register(@RequestBody RegisterRequestDto request) {
        final TokenResponse token = authService.register(request);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequestDto request) {
        final TokenResponse token = authService.login(request);
        return ResponseEntity.ok(token);
    }
    @PostMapping("/refresh)
            public  ResponseEntity <TokenResponse> refresh(@RequestHeader(HttpHeaders.AUTHORIZATION)final String authHeader){
                return authService.refreshToken(authHeader);
            }
}
