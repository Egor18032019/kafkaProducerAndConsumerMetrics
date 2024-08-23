package org.example.api;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.service.MetricsServiceCommon;
import org.example.utils.EndPoint;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = EndPoint.metrics)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class MetricsController {
    MetricsServiceCommon service;

    @PostMapping
    @Operation(summary = "Получение метрик и отправка их в кафку.")
    public void collectMetrics() {
        service.sendMetrics();
    }
}
