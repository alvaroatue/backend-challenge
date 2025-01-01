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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlantEntity getPlant() {
        return plant;
    }

    public void setPlant(PlantEntity plant) {
        this.plant = plant;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getWingSpeed() {
        return wingSpeed;
    }

    public void setWingSpeed(double wingSpeed) {
        this.wingSpeed = wingSpeed;
    }

    public double getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(double energyLevel) {
        this.energyLevel = energyLevel;
    }

    public double getTension() {
        return tension;
    }

    public void setTension(double tension) {
        this.tension = tension;
    }

    public double getCarbonMonoxide() {
        return carbonMonoxide;
    }

    public void setCarbonMonoxide(double carbonMonoxide) {
        this.carbonMonoxide = carbonMonoxide;
    }

    public double getOtherGases() {
        return otherGases;
    }

    public void setOtherGases(double otherGases) {
        this.otherGases = otherGases;
    }
}
