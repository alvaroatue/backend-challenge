package com.example.backend_challenge.Repositories;

import com.example.backend_challenge.Entities.PlantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantRepository extends JpaRepository<PlantEntity, Long> {

    PlantEntity findByName(String name);

    List<PlantEntity> findByIdIn(List<Long> plantIds);
    Boolean existsByName(String name);
}
