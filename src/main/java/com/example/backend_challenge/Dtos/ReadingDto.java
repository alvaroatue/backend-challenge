package com.example.backend_challenge.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadingDto {
    Long id;
    Long plantId;
    LocalDateTime timestamp;
    Double temperature;
    Double pressure;
    Double wingSpeed;
    Double energyLevel;
    Double tension;
    Double carbonMonoxide;
    Double otherGases;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlantId() {
        return plantId;
    }

    public void setPlantId(Long plantId) {
        this.plantId = plantId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getWingSpeed() {
        return wingSpeed;
    }

    public void setWingSpeed(Double wingSpeed) {
        this.wingSpeed = wingSpeed;
    }

    public Double getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(Double energyLevel) {
        this.energyLevel = energyLevel;
    }

    public Double getCarbonMonoxide() {
        return carbonMonoxide;
    }

    public void setCarbonMonoxide(Double carbonMonoxide) {
        this.carbonMonoxide = carbonMonoxide;
    }

    public Double getTension() {
        return tension;
    }

    public void setTension(Double tension) {
        this.tension = tension;
    }

    public Double getOtherGases() {
        return otherGases;
    }

    public void setOtherGases(Double otherGases) {
        this.otherGases = otherGases;
    }
}
