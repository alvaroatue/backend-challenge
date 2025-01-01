package com.example.backend_challenge.Services;

import com.example.backend_challenge.Dtos.AlertDto;
import com.example.backend_challenge.Entities.AlertEntity;
import com.example.backend_challenge.Entities.PlantEntity;
import com.example.backend_challenge.Mappers.AlertMapper;
import com.example.backend_challenge.Repositories.AlertRepository;
import com.example.backend_challenge.Repositories.PlantRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlertService {

    private final AlertRepository alertRepository;
    private final PlantRepository plantRepository;
    private final AlertMapper alertMapper;

    public AlertService(AlertRepository alertRepository, PlantRepository plantRepository, AlertMapper alertMapper) {
        this.alertRepository = alertRepository;
        this.plantRepository = plantRepository;
        this.alertMapper = alertMapper;
    }

    public List<AlertDto> getAllAlerts() {
        return alertRepository.findAll()
                .stream()
                .map(alertMapper::toDto)
                .collect(Collectors.toList());
    }

    public AlertDto getAlertById(Long id) {
        Optional<AlertEntity> alert = alertRepository.findById(id);
        return alert.map(alertMapper::toDto).orElse(null);
    }

    public AlertDto createAlert(AlertDto alertDto) {
        Optional<PlantEntity> plant = plantRepository.findById(alertDto.getPlantId());
        if (plant.isEmpty()) {
            return null;
        }
        AlertEntity alertEntity = alertMapper.toEntity(alertDto, plant.get());
        AlertEntity savedAlert = alertRepository.save(alertEntity);
        return alertMapper.toDto(savedAlert);
    }

    public AlertDto updateAlert(Long id, AlertDto alertDto) {
        Optional<AlertEntity> alert = alertRepository.findById(id);
        if (alert.isEmpty()) {
            return null;
        }
        Optional<PlantEntity> plant = plantRepository.findById(alertDto.getPlantId());
        if (plant.isEmpty()) {
            return null;
        }
        AlertEntity alertEntity = alertMapper.toEntity(alertDto, plant.get());
        alertEntity.setId(id);
        AlertEntity savedAlert = alertRepository.save(alertEntity);
        return alertMapper.toDto(savedAlert);
    }

    public void deleteAlert(Long id) {
        if (alertRepository.existsById(id)) {
            alertRepository.deleteById(id);
        }
    }

    public Boolean existsByPlantIdAndTimestamp(Long plantId, LocalDateTime timestamp) {
        return alertRepository.existsByPlantIdAndTimestamp(plantId, timestamp);
    }
}