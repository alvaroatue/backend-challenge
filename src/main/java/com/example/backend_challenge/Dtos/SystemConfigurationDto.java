
package com.example.backend_challenge.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemConfigurationDto {
    private Long id;
    private String configKey;
    private String configValue;
    private String description;
    private LocalDateTime lastUpdated;
    private Long updatedByUserId;
}