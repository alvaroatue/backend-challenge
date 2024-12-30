package com.example.backend_challenge.Entities;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Readings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReadingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private PlantEntity plant;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private double temperature;

    @Column(nullable = false)
    private double pressure;

    @Column(nullable = false)
    private double wingSpeed;

    @Column(nullable = false)
    private double energyLevel;

    @Column(nullable = false)
    private double tension;

    @Column(nullable = false)
    private double carbonMonoxide;

    @Column(nullable = false)
    private double otherGases;



}
