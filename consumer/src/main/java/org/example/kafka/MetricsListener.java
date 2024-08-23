package org.example.kafka;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.mapper.MetricsMapper;
import org.example.model.MetricModel;
import org.example.store.MetricsEntity;
import org.example.store.MetricsRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Getter
@Component
@Transactional
@RequiredArgsConstructor
public class MetricsListener {
    private final MetricsRepository repository;
    private final MetricsMapper metricsMapper;
    private UUID payload;

    @KafkaListener(id = "1", topics = "metrics-topic")
    public void listen(MetricModel metricsDto) {
        log.info("Received metrics: {}", metricsDto);
        MetricsEntity entity = metricsMapper.dtoToEntity(metricsDto);
        payload = metricsDto.getId();
        repository.save(entity);
        log.info("Metrics сохранили в бд");
    }
}
