package com.example.backend_challenge.Services;

import com.example.backend_challenge.Entities.UserEntity;
import lombok.Value;

public class JwtService implements JwtSer {


    private String secret;

    private long jwtExpiration;

    private long refreshExpiration;

}
