package com.example.backend_challenge.Mappers;


import com.example.backend_challenge.Dtos.AlertDto;
import com.example.backend_challenge.Entities.AlertEntity;
import com.example.backend_challenge.Entities.PlantEntity;
import com.example.backend_challenge.Enums.AlertType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class AlertMapper {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    public AlertDto toDto(AlertEntity alertEntity) {
        AlertDto alertDto = new AlertDto();
        alertDto.setId(alertEntity.getId());
        alertDto.setPlantId(alertEntity.getPlant().getId());
        alertDto.setTimestamp(alertEntity.getTimestamp().format(formatter));
        alertDto.setAlertType(alertEntity.getType().name());
        alertDto.setMessage(alertEntity.getMessage());
        return alertDto;
    }

    public AlertEntity toEntity(AlertDto alertDto, PlantEntity plantEntity) {
        AlertEntity alertEntity = new AlertEntity();
        alertEntity.setId(alertDto.getId());
        alertEntity.setPlant(plantEntity);
        alertEntity.setTimestamp(LocalDateTime.parse(alertDto.getTimestamp(), formatter));
        alertEntity.setType(AlertType.valueOf(alertDto.getAlertType()));
        alertEntity.setMessage(alertDto.getMessage());
        return alertEntity;
    }
}
