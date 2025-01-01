package com.example.backend_challenge.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Plants")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @OneToMany(mappedBy = "plant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ReadingEntity> readings;

    @OneToMany(mappedBy = "plant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<AlertEntity> alerts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ReadingEntity> getReadings() {
        return readings;
    }

    public void setReadings(List<ReadingEntity> readings) {
        this.readings = readings;
    }

    public List<AlertEntity> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<AlertEntity> alerts) {
        this.alerts = alerts;
    }



}

