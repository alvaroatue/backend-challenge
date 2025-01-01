package com.example.backend_challenge.Repositories;

import com.example.backend_challenge.Entities.AlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<AlertEntity, Long> {
    Boolean existsByPlantIdAndTimestamp(Long plantId, java.time.LocalDateTime timestamp);
}
