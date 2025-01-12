package com.example.backend_challenge.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "system_configurations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemConfigurationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String configKey;

    @Column(nullable = false)
    private String configValue;

    @Column
    private String description;

    @Column(nullable = false)
    private LocalDateTime lastUpdated;

    @ManyToOne
    @JoinColumn(name = "updated_by_user_id")
    private UserEntity updatedByUser;
}