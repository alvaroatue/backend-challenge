package com.example.backend_challenge.Controllers;

import com.example.backend_challenge.Dtos.ReadingDto;
import com.example.backend_challenge.Services.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readings")
public class ReadingController {

    private final ReadingService readingService;

    @Autowired
    public ReadingController(ReadingService readingService) {
        this.readingService = readingService;
    }

    @GetMapping
    public List<ReadingDto> getAllReadings() {
        return readingService.getAllReadings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadingDto> getReadingById(@PathVariable Long id) {
        ReadingDto reading = readingService.getReadingById(id);
        return reading != null ? ResponseEntity.ok(reading) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ReadingDto> createReading(@RequestBody ReadingDto readingDto) {
        ReadingDto reading = readingService.createReading(readingDto);
        return ResponseEntity.ok(reading);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReadingDto> updateReading(@PathVariable Long id, @RequestBody ReadingDto readingDto) {
        ReadingDto reading = readingService.updateReading(id, readingDto);
        return reading != null ? ResponseEntity.ok(reading) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReading(@PathVariable Long id) {
        readingService.deleteReading(id);
        return ResponseEntity.noContent().build();
    }
}