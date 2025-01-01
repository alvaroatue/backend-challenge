package com.example.backend_challenge.Services;

import com.example.backend_challenge.Dtos.ReadingDto;
import com.example.backend_challenge.Entities.ReadingEntity;
import com.example.backend_challenge.Mappers.ReadingMapper;
import com.example.backend_challenge.Repositories.ReadingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReadingService {

    private final ReadingRepository readingRepository;
    private final ReadingMapper readingMapper;

    public ReadingService(ReadingRepository readingRepository, ReadingMapper readingMapper) {
        this.readingRepository = readingRepository;
        this.readingMapper = readingMapper;
    }

    public List<ReadingDto> getAllReadings() {
        return readingRepository.findAll()
                .stream()
                .map(readingMapper::toDto)
                .collect(Collectors.toList());
    }

    public ReadingDto getReadingById(Long id) {
        Optional<ReadingEntity> reading = readingRepository.findById(id);
        return reading.map(readingMapper::toDto).orElse(null);
    }

    public ReadingDto createReading(ReadingDto readingDto) {
        ReadingEntity readingEntity = readingMapper.toEntity(readingDto);
        ReadingEntity savedReading = readingRepository.save(readingEntity);
        return readingMapper.toDto(savedReading);
    }

    public ReadingDto updateReading(Long id, ReadingDto readingDto) {
        Optional<ReadingEntity> reading = readingRepository.findById(id);
        if (reading.isEmpty()) {
            return null;
        }
        ReadingEntity readingEntity = readingMapper.toEntity(readingDto);
        readingEntity.setId(id);
        ReadingEntity savedReading = readingRepository.save(readingEntity);
        return readingMapper.toDto(savedReading);
    }

    public void deleteReading(Long id) {
        if (readingRepository.existsById(id)) {
            readingRepository.deleteById(id);
        }
    }
}