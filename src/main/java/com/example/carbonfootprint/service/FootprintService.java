package com.example.carbonfootprint.service;

import com.example.carbonfootprint.model.FootprintLog;
import com.example.carbonfootprint.repository.FootprintLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootprintService {

    private final FootprintLogRepository repository;
    // default emission factor if not provided
    private static final double DEFAULT_EMISSION_FACTOR = 0.21;

    public FootprintService(FootprintLogRepository repository) {
        this.repository = repository;
    }

    public FootprintLog calculateAndSave(double distanceKm) {
        return calculateAndSave(distanceKm, DEFAULT_EMISSION_FACTOR);
    }

    public FootprintLog calculateAndSave(double distanceKm, double emissionFactor) {
        double result = distanceKm * emissionFactor;
        FootprintLog log = new FootprintLog();
        log.setDistanceKm(distanceKm);
        log.setEmissionFactor(emissionFactor);
        log.setResultKgCO2(result);
        // createdAt set by default field initializer
        return repository.save(log);
    }

    public List<FootprintLog> findAllHistory() {
        return repository.findAll();
    }
}
