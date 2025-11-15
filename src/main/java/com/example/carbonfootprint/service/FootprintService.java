package com.example.carbonfootprint.service;

import com.example.carbonfootprint.model.FootprintResponse;
import org.springframework.stereotype.Service;

@Service
public class FootprintService {

    // carbon emission factor (average car) = 0.192 kg CO2 per km
    private static final double EMISSION_FACTOR = 0.192;

    public FootprintResponse calculate(double km) {
        double result = km * EMISSION_FACTOR;
        return new FootprintResponse(km, result);
    }
}
