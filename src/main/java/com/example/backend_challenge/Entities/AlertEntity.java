package com.example.backend_challenge.Entities;


import com.example.backend_challenge.Enums.AlertType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Alerts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AlertEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private PlantEntity plant;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AlertType type;
}

