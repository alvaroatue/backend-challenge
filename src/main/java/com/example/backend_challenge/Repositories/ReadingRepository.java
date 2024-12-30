package com.example.backend_challenge.Repositories;

import com.example.backend_challenge.Entities.ReadingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingRepository extends JpaRepository<ReadingEntity, Long> {
    ReadingEntity findByPlantId(Long plantId);
    ReadingEntity findByPlantIdAndTimestamp(Long plantId, Long timestamp);
    List<ReadingEntity> findByPlantIdIn(List<Long> plantIds);
    List<ReadingEntity> findByPlantIdAndTimestampBetween(Long plantId, Long startTimestamp, Long endTimestamp);
    List<ReadingEntity> findByPlantIdAndTimestampGreaterThanEqual(Long plantId, Long startTimestamp);
    List<ReadingEntity> findByPlantIdAndTimestampLessThanEqual(Long plantId, Long endTimestamp);
    List<ReadingEntity> findByPlantIdAndTimestampGreaterThanEqualAndTimestampLessThanEqual(Long plantId, Long startTimestamp, Long endTimestamp);
    Boolean existsByPlantId(Long plantId);
    Boolean existsByPlantIdAndTimestamp(Long plantId, Long timestamp);
}
