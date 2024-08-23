package org.example.mapper;

import org.example.model.ListMetricModel;
import org.example.model.MetricModel;
import org.example.store.MetricsEntity;

import java.util.List;


public interface MetricsMapper {

    MetricsEntity dtoToEntity(MetricModel model);

    MetricModel entityToDto(MetricsEntity entity);
    ListMetricModel listEntityToDto(List<MetricsEntity> entity);

    List<MetricModel> entitiesToDtos(List<MetricsEntity> entity);
}
