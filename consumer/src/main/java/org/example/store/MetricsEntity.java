package org.example.store;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "methods")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MetricsEntity {
    @Id
    private UUID id;
    @Column()
    private LocalDateTime timestamp;
    @Column()
    private String name;
    @Column()
    private double value;
}
