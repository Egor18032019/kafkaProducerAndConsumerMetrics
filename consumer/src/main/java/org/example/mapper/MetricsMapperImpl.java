package org.example.mapper;

import org.example.model.MetricModel;
import org.example.store.MetricsEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MetricsMapperImpl implements MetricsMapper {
    @Override
    public MetricsEntity dtoToEntity(MetricModel model) {

        return new MetricsEntity(model.getId(), model.getTimestamp(), model.getName(), model.getValue());
    }

    @Override
    public MetricModel entityToDto(MetricsEntity entity) {
        return new MetricModel(entity.getId(), entity.getTimestamp(), entity.getName(), entity.getValue());
    }

    @Override
    public List<MetricModel> entitiesToDtos(List<MetricsEntity> entity) {
        List<MetricModel> list = new ArrayList<>();
        for (MetricsEntity point : entity) {
            MetricModel model = entityToDto(point);
            list.add(model);
        }
        return list;
    }
}
