package org.example.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.example.exception.NotFoundException;
import org.example.mapper.MetricsMapper;
import org.example.model.MetricModel;
import org.example.store.MetricsEntity;
import org.example.store.MetricsRepository;
import org.example.utils.EndPoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = EndPoint.metrics)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Tag(name="Metrics Consumer", description="REST API для просмотра метрик.")
public class MetricsController {
    MetricsRepository repository;
    MetricsMapper mapper;

    public MetricsController(MetricsRepository repository, MetricsMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(summary = "Выдача всех метрик из бд.")
    public List<MetricModel> getAllMetrics() {
        List<MetricsEntity> metricsEntities = repository.findAll();
        return mapper.entitiesToDtos(metricsEntities);
    }

    @Operation(
            summary = "Получение конкретной метрики по ее идентификатору.",
            description = "Ждет на вход id(UUID) метрики."
    )
    @GetMapping(path = "/{id}")
    public MetricModel getOneMetricById(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        MetricsEntity metricsEntity = repository
                .findById(uuid)
                .orElseThrow(() -> new NotFoundException("Metric with uuid = " + uuid
                        + " was not found"));
        return mapper.entityToDto(metricsEntity);
    }
}
