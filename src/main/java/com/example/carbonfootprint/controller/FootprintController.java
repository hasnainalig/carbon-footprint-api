package com.example.carbonfootprint.controller;

import com.example.carbonfootprint.model.FootprintResponse;
import com.example.carbonfootprint.service.FootprintService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FootprintController {

    private final FootprintService service;

    public FootprintController(FootprintService service) {
        this.service = service;
    }

    @GetMapping("/footprint")
    public FootprintResponse getFootprint(@RequestParam double km) {
        return service.calculate(km);
    }
}
