package com.example.backend_challenge.Controllers;

import com.example.backend_challenge.Dtos.PlantDto;
import com.example.backend_challenge.Services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
public class PlantController {

    private final PlantService plantService;

    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping
    public List<PlantDto> getAllPlants() {
        return plantService.getAllPlants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantDto> getPlantById(@PathVariable Long id) {
        PlantDto plant = plantService.getPlantById(id);
        return plant != null ? ResponseEntity.ok(plant) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PlantDto> createPlant(@RequestBody PlantDto plantDto) {
        PlantDto plant = plantService.createPlant(plantDto);
        return ResponseEntity.ok(plant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlantDto> updatePlant(@PathVariable Long id, @RequestBody PlantDto plantDto) {
        PlantDto plant = plantService.updatePlant(id, plantDto);
        return plant != null ? ResponseEntity.ok(plant) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlant(@PathVariable Long id) {
        plantService.deletePlant(id);
        return ResponseEntity.noContent().build();
    }
}