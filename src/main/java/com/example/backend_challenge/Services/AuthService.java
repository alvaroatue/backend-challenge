package com.example.backend_challenge.Services;


import com.example.backend_challenge.Dtos.TokenResponse;
import com.example.backend_challenge.Dtos.LoginRequestDto;
import com.example.backend_challenge.Dtos.RegisterRequestDto;
import com.example.backend_challenge.Entities.TokenEntity;
import com.example.backend_challenge.Entities.UserEntity;
import com.example.backend_challenge.Enums.TokenType;
import com.example.backend_challenge.Repositories.TokenRepository;
import com.example.backend_challenge.Repositories.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Builder
public class AuthService {

        private final UserRepository userRepository;
        private final TokenRepository tokenRepository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

    public void register(RegisterRequestDto request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        var user = UserEntity.builder()
                .name(request.getName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
    }

    public TokenResponse login(LoginRequestDto request) {
        try {
            System.out.println("Attempting to authenticate user: " + request.getEmail());

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

            System.out.println("Authentication successful");

            var user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            var jwtToken = jwtService.generateToken(user);
            System.out.println("Generated token: " + jwtToken);

            revokeAllUserTokens(user);
            saveUserToken(user, jwtToken);

            return TokenResponse.builder()
                    .token(jwtToken)
                    .build();
        } catch (Exception e) {
            System.out.println("Authentication failed: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    private void saveUserToken(UserEntity user, String jwtToken) {
        System.out.println("Saving token for user: " + user.getEmail());
        var token = TokenEntity.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
        System.out.println("Token saved successfully");
    }

    private void revokeAllUserTokens(UserEntity user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty()) return;

        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public TokenResponse refreshToken(String oldToken) {
        String email = jwtService.extractUsername(oldToken);
        if (email == null) {
            throw new IllegalArgumentException("Invalid token: email not found");
        }

        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + email));

        if (!jwtService.isTokenValid(oldToken, user)) {
            throw new IllegalArgumentException("Invalid or expired token");
        }

        String newToken = jwtService.generateToken(user);
        return TokenResponse.builder().token(newToken).build();
    }
}