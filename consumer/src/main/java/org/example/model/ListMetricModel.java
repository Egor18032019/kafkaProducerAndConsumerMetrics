package org.example.model;

import lombok.*;

import java.util.List;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ListMetricModel {
    List<MetricModel> list;
}
