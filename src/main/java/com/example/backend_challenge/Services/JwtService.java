package com.example.backend_challenge.Services;

import com.example.backend_challenge.Entities.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Service
public class JwtService  {
    @Value("${application.security.jwt.secret-key}")
    private String secretKey;

    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration;

    @Value("${application.security.jwt.refresh-token.expiration}")
    private long refreshTokenExpiration;


    private String generateToken(final UserEntity user) {
        return buildToken(user, jwtExpiration);
    }

    private String generateRefreshToken(final UserEntity user) {
        return buildToken(user, refreshTokenExpiration);
    }


    private String buildToken(final UserEntity user, final long expiration) {
       return Jwts.builder()
               .id(user.getId().toString())
               .claims(Map.of("name",user.getName())
                       .subject(user.getEmail())
                       .issuedAt(new Date(System.currentTimeMillis()))
                          .expiration(new Date(System.currentTimeMillis() + expiration))
                       .signWith(getSingningKey())
                       .compact();
    }

    private SecretKey getSingningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
