
package com.example.backend_challenge.Repositories;

import com.example.backend_challenge.Entities.SystemConfigurationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemConfigurationRepository extends JpaRepository<SystemConfigurationEntity, Long> {
}