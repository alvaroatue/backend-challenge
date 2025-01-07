package com.example.backend_challenge.Mappers;

import com.example.backend_challenge.Dtos.UserDto;
import com.example.backend_challenge.Entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setEmail(userEntity.getEmail());
        userDto.setName(userEntity.getName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setUsername(userEntity.getUsername());
        userDto.setPassword(userEntity.getPassword());
        return userDto;
    }

    public UserEntity toEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDto.getEmail());
        userEntity.setName(userDto.getName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setId(userDto.getId());
        return userEntity;
    }
}
