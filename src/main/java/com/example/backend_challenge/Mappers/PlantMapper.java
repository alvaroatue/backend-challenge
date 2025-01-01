package com.example.backend_challenge.Mappers;

import com.example.backend_challenge.Dtos.PlantDto;
import com.example.backend_challenge.Entities.PlantEntity;
import org.springframework.stereotype.Component;

@Component
public class PlantMapper {

    public PlantDto toDto(PlantEntity plantEntity) {
        PlantDto plantDto = new PlantDto();
        plantDto.setId(plantEntity.getId());
        plantDto.setName(plantEntity.getName());
        plantDto.setCountry(plantEntity.getCountry());
        return plantDto;
    }

    public PlantEntity toEntity(PlantDto plantDto) {
        PlantEntity plantEntity = new PlantEntity();
        plantEntity.setId(plantDto.getId());
        plantEntity.setName(plantDto.getName());
        plantEntity.setCountry(plantDto.getCountry());
        return plantEntity;
    }
}
