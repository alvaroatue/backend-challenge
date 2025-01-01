package com.example.backend_challenge.Repositories;

import com.example.backend_challenge.Entities.ReadingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReadingRepository extends JpaRepository<ReadingEntity, Long> {
    ReadingEntity findByPlantId(Long plantId);
    ReadingEntity findByPlantIdAndTimestamp(Long plantId, LocalDateTime timestamp);
    List<ReadingEntity> findByPlantIdIn(List<Long> plantIds);
    List<ReadingEntity> findByPlantIdAndTimestampBetween(Long plantId, LocalDateTime startTimestamp, LocalDateTime endTimestamp);
    List<ReadingEntity> findByPlantIdAndTimestampGreaterThanEqual(Long plantId, LocalDateTime startTimestamp);
    List<ReadingEntity> findByPlantIdAndTimestampLessThanEqual(Long plantId, LocalDateTime endTimestamp);
    List<ReadingEntity> findByPlantIdAndTimestampGreaterThanEqualAndTimestampLessThanEqual(Long plantId, LocalDateTime startTimestamp, LocalDateTime endTimestamp);
    Boolean existsByPlantId(Long plantId);
    Boolean existsByPlantIdAndTimestamp(Long plantId, LocalDateTime timestamp);
}
