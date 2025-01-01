package com.example.backend_challenge.Controllers;

import com.example.backend_challenge.Dtos.AlertDto;
import com.example.backend_challenge.Services.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    private final AlertService alertService;

    @Autowired
    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping
    public List<AlertDto> getAllAlerts() {
        return alertService.getAllAlerts();
    }

    @GetMapping("/{id}")
    public AlertDto getAlertById(@PathVariable Long id) {
        return alertService.getAlertById(id);
    }

    @PostMapping
    public AlertDto createAlert(@RequestBody AlertDto alertDto) {
        return alertService.createAlert(alertDto);
    }

    @PutMapping("/{id}")
    public AlertDto updateAlert(@PathVariable Long id, @RequestBody AlertDto alertDto) {
        return alertService.updateAlert(id, alertDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAlert(@PathVariable Long id) {
        alertService.deleteAlert(id);
    }

    @GetMapping("/exists")
    public Boolean existsByPlantIdAndTimestamp(@RequestParam Long plantId, @RequestParam LocalDateTime timestamp) {
        return alertService.existsByPlantIdAndTimestamp(plantId, timestamp);
    }
}