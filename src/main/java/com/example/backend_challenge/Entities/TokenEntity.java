    package com.example.backend_challenge.Entities;

    import com.example.backend_challenge.Enums.TokenType;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Data
    @Table(name = "tokens")
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Builder
    public class TokenEntity {
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long id;

        @Column (unique = true)
        private String token;

        @Enumerated(EnumType.STRING)
        private TokenType tokenType = TokenType.BEARER;

        boolean expired;

        boolean revoked;

        @ManyToOne (fetch = FetchType.LAZY)
        @JoinColumn  (name = "user_id")
        UserEntity user;

    }
