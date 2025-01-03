package com.example.backend_challenge.Repositories;

import com.example.backend_challenge.Entities.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<TokenEntity, Long> {
    TokenEntity findByToken(String token);
}
