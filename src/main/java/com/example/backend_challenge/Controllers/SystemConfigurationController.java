package com.example.backend_challenge.Controllers;

import com.example.backend_challenge.Dtos.SystemConfigurationDto;
import com.example.backend_challenge.Services.SystemConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/system-configurations")
@RequiredArgsConstructor
public class SystemConfigurationController {

    private final SystemConfigurationService systemConfigurationService;

    @GetMapping
    public ResponseEntity<List<SystemConfigurationDto>> getAllConfigurations() {
        List<SystemConfigurationDto> configurations = systemConfigurationService.getAllConfigurations();
        return ResponseEntity.ok(configurations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SystemConfigurationDto> getConfigurationById(@PathVariable Long id) {
        SystemConfigurationDto configuration = systemConfigurationService.getConfigurationById(id);
        return configuration != null ? ResponseEntity.ok(configuration) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<SystemConfigurationDto> createConfiguration(@RequestBody SystemConfigurationDto dto) {
        SystemConfigurationDto createdConfiguration = systemConfigurationService.createConfiguration(dto);
        return ResponseEntity.ok(createdConfiguration);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SystemConfigurationDto> updateConfiguration(@PathVariable Long id, @RequestBody SystemConfigurationDto dto) {
        SystemConfigurationDto updatedConfiguration = systemConfigurationService.updateConfiguration(id, dto);
        return updatedConfiguration != null ? ResponseEntity.ok(updatedConfiguration) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConfiguration(@PathVariable Long id) {
        systemConfigurationService.deleteConfiguration(id);
        return ResponseEntity.noContent().build();
    }
}