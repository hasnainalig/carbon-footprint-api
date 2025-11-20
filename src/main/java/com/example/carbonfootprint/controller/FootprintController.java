package com.example.carbonfootprint.controller;

import com.example.carbonfootprint.model.FootprintLog;
import com.example.carbonfootprint.service.FootprintService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Carbon Footprint", description = "Endpoints for carbon footprint calculations")
@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class FootprintController {

    private final FootprintService service;

    public FootprintController(FootprintService service) {
        this.service = service;
    }

    @Operation(summary = "Calculate Carbon Footprint and save to history (Protected)")
    @GetMapping("/footprint")
    public ResponseEntity<FootprintLog> getFootprint(
            @RequestParam double distance,
            @RequestParam(required = false) Double emissionFactor
    ) {
        FootprintLog saved = (emissionFactor == null)
                ? service.calculateAndSave(distance)
                : service.calculateAndSave(distance, emissionFactor);
        return ResponseEntity.ok(saved);
    }

    @Operation(summary = "Get calculation history")
    @GetMapping("/history")
    public ResponseEntity<List<FootprintLog>> history() {
        return ResponseEntity.ok(service.findAllHistory());
    }
}
