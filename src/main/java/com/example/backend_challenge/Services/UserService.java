package com.example.backend_challenge.Services;

import com.example.backend_challenge.Dtos.UserDto;
import com.example.backend_challenge.Entities.UserEntity;
import com.example.backend_challenge.Mappers.UserMapper;
import com.example.backend_challenge.Repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    public List<UserDto> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
      Optional<UserEntity> user = userRepository.findById(id);
        return user.map(userMapper::toDto).orElse(null);
    }
    public UserDto createUser(UserDto userDto) {

        Optional<UserEntity> user = userRepository.findByEmail(userDto.getEmail());
        if(user.isPresent())
        {
            throw new IllegalArgumentException("User with this mail already exists");
        }
        UserEntity userEntity = userMapper.toEntity(userDto);
        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.toDto(savedUser);
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isEmpty())
        {
            return null;
        }
        UserEntity userEntity = userMapper.toEntity(userDto);
        userEntity.setId(id);
        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.toDto(savedUser);
    }

    public void deleteUser(Long id) {
        if(userRepository.existsById(id))
        {
            userRepository.deleteById(id);
        }
    }
}
