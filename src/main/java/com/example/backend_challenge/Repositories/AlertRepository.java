package com.example.backend_challenge.Repositories;

import com.example.backend_challenge.Entities.AlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<AlertEntity, Long> {
    AlertEntity findByPlantId(Long plantId);
    AlertEntity findByPlantIdAndTimestamp(Long plantId, Long timestamp);
    Boolean existsByPlantId(Long plantId);
    Boolean existsByPlantIdAndTimestamp(Long plantId, Long timestamp);
}
