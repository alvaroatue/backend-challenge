package com.example.backend_challenge.Mappers;

import com.example.backend_challenge.Dtos.ReadingDto;
import com.example.backend_challenge.Entities.PlantEntity;
import com.example.backend_challenge.Entities.ReadingEntity;
import org.springframework.stereotype.Component;

@Component
public class ReadingMapper {

    public ReadingDto toDto(ReadingEntity readingEntity) {
        ReadingDto readingDto = new ReadingDto();
        readingDto.setId(readingEntity.getId());
        readingDto.setPlantId(readingEntity.getPlant().getId());
        readingDto.setTimestamp(readingEntity.getTimestamp());
        readingDto.setTemperature(readingEntity.getTemperature());
        readingDto.setPressure(readingEntity.getPressure());
        readingDto.setWingSpeed(readingEntity.getWingSpeed());
        readingDto.setEnergyLevel(readingEntity.getEnergyLevel());
        readingDto.setTension(readingEntity.getTension());
        readingDto.setCarbonMonoxide(readingEntity.getCarbonMonoxide());
        readingDto.setOtherGases(readingEntity.getOtherGases());
        readingDto.setSensorStatus(readingEntity.getSensorStatus());
        return readingDto;
    }

    public ReadingEntity toEntity(ReadingDto readingDto) {
        ReadingEntity readingEntity = new ReadingEntity();
        readingEntity.setId(readingDto.getId());
        readingEntity.setPlant(fetchPlantById(readingDto.getPlantId()));
        readingEntity.setTimestamp(readingDto.getTimestamp());
        readingEntity.setTemperature(readingDto.getTemperature());
        readingEntity.setPressure(readingDto.getPressure());
        readingEntity.setWingSpeed(readingDto.getWingSpeed());
        readingEntity.setEnergyLevel(readingDto.getEnergyLevel());
        readingEntity.setTension(readingDto.getTension());
        readingEntity.setCarbonMonoxide(readingDto.getCarbonMonoxide());
        readingEntity.setOtherGases(readingDto.getOtherGases());
        readingEntity.setSensorStatus(readingDto.getSensorStatus());
        return readingEntity;
    }

    private PlantEntity fetchPlantById(Long plantId) {
        // Implement this method to fetch PlantEntity by ID
        return new PlantEntity(); // Placeholder
    }
}