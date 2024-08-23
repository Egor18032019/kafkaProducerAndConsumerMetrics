package org.example.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MetricModel {
    private UUID id;
    private LocalDateTime timestamp;
    private String name;
    private double value;
}
