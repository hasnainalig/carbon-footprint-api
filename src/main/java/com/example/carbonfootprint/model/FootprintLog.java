package com.example.carbonfootprint.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "footprint_logs")
public class FootprintLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double distanceKm;
    private double emissionFactor;   // kg CO2 per km used for calculation
    private double resultKgCO2;

    private LocalDateTime createdAt = LocalDateTime.now();
}
