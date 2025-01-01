package com.example.backend_challenge.Services;

import com.example.backend_challenge.Dtos.PlantDto;
import com.example.backend_challenge.Entities.PlantEntity;
import com.example.backend_challenge.Mappers.PlantMapper;
import com.example.backend_challenge.Repositories.PlantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlantService {

    private final PlantRepository plantRepository;
    private final PlantMapper plantMapper;

    public PlantService(PlantRepository plantRepository, PlantMapper plantMapper) {
        this.plantRepository = plantRepository;
        this.plantMapper = plantMapper;
    }

    public List<PlantDto> getAllPlants() {
        return plantRepository.findAll()
                .stream()
                .map(plantMapper::toDto)
                .collect(Collectors.toList());
    }

    public PlantDto getPlantById(Long id) {
        Optional<PlantEntity> plant = plantRepository.findById(id);
        return plant.map(plantMapper::toDto).orElse(null);
    }

    public PlantDto createPlant(PlantDto plantDto) {
        PlantEntity plantEntity = plantMapper.toEntity(plantDto);
        PlantEntity savedPlant = plantRepository.save(plantEntity);
        return plantMapper.toDto(savedPlant);
    }

    public PlantDto updatePlant(Long id, PlantDto plantDto) {
        Optional<PlantEntity> plant = plantRepository.findById(id);
        if (plant.isEmpty()) {
            return null;
        }
        PlantEntity plantEntity = plantMapper.toEntity(plantDto);
        plantEntity.setId(id);
        PlantEntity savedPlant = plantRepository.save(plantEntity);
        return plantMapper.toDto(savedPlant);
    }

    public void deletePlant(Long id) {
        if (plantRepository.existsById(id)) {
            plantRepository.deleteById(id);
        }
    }
}