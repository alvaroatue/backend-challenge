
package com.example.backend_challenge.Services;

import com.example.backend_challenge.Dtos.SystemConfigurationDto;
import com.example.backend_challenge.Entities.SystemConfigurationEntity;
import com.example.backend_challenge.Entities.UserEntity;
import com.example.backend_challenge.Mappers.SystemConfigurationMapper;
import com.example.backend_challenge.Repositories.SystemConfigurationRepository;
import com.example.backend_challenge.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SystemConfigurationService {
    private final SystemConfigurationRepository systemConfigurationRepository;
    private final UserRepository userRepository;
    private final SystemConfigurationMapper systemConfigurationMapper;

    public List<SystemConfigurationDto> getAllConfigurations() {
        return systemConfigurationRepository.findAll()
                .stream()
                .map(systemConfigurationMapper::toDto)
                .collect(Collectors.toList());
    }

    public SystemConfigurationDto getConfigurationById(Long id) {
        Optional<SystemConfigurationEntity> config = systemConfigurationRepository.findById(id);
        return config.map(systemConfigurationMapper::toDto).orElse(null);
    }

    public SystemConfigurationDto createConfiguration(SystemConfigurationDto dto) {
        UserEntity user = userRepository.findById(dto.getUpdatedByUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        SystemConfigurationEntity entity = systemConfigurationMapper.toEntity(dto, user);
        SystemConfigurationEntity savedEntity = systemConfigurationRepository.save(entity);
        return systemConfigurationMapper.toDto(savedEntity);
    }

    public SystemConfigurationDto updateConfiguration(Long id, SystemConfigurationDto dto) {
        Optional<SystemConfigurationEntity> existingConfig = systemConfigurationRepository.findById(id);
        if (existingConfig.isEmpty()) {
            return null;
        }
        UserEntity user = userRepository.findById(dto.getUpdatedByUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        SystemConfigurationEntity entity = systemConfigurationMapper.toEntity(dto, user);
        entity.setId(id);
        SystemConfigurationEntity updatedEntity = systemConfigurationRepository.save(entity);
        return systemConfigurationMapper.toDto(updatedEntity);
    }

    public void deleteConfiguration(Long id) {
        if (systemConfigurationRepository.existsById(id)) {
            systemConfigurationRepository.deleteById(id);
        }
    }
}