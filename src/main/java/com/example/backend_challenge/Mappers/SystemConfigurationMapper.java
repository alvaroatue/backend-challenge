
package com.example.backend_challenge.Mappers;

import com.example.backend_challenge.Dtos.SystemConfigurationDto;
import com.example.backend_challenge.Entities.SystemConfigurationEntity;
import com.example.backend_challenge.Entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class SystemConfigurationMapper {

    public SystemConfigurationDto toDto(SystemConfigurationEntity entity) {
        SystemConfigurationDto dto = new SystemConfigurationDto();
        dto.setId(entity.getId());
        dto.setConfigKey(entity.getConfigKey());
        dto.setConfigValue(entity.getConfigValue());
        dto.setDescription(entity.getDescription());
        dto.setLastUpdated(entity.getLastUpdated());
        dto.setUpdatedByUserId(entity.getUpdatedByUser() != null ? entity.getUpdatedByUser().getId() : null);
        return dto;
    }

    public SystemConfigurationEntity toEntity(SystemConfigurationDto dto, UserEntity user) {
        SystemConfigurationEntity entity = new SystemConfigurationEntity();
        entity.setId(dto.getId());
        entity.setConfigKey(dto.getConfigKey());
        entity.setConfigValue(dto.getConfigValue());
        entity.setDescription(dto.getDescription());
        entity.setLastUpdated(dto.getLastUpdated());
        entity.setUpdatedByUser(user);
        return entity;
    }
}