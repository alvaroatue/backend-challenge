package com.example.backend_challenge.Repositories;

import com.example.backend_challenge.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional <UserEntity> findByEmail(String email);
    Optional<UserEntity> findById(Long id);
    Boolean existsByEmail(String email);

    Optional<UserEntity> findByEmailAndPassword(String email, String password);
}
