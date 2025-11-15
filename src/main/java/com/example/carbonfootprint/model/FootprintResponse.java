package com.example.carbonfootprint.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FootprintResponse {
    private double distanceKm;
    private double emissionKgCO2;
}
