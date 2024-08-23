package org.example.kafka;


import org.apache.kafka.clients.admin.NewTopic;
import org.example.utils.EndPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {

    @Bean
    public NewTopic metricsTopic() {
        return new NewTopic(EndPoint.topic, 1, (short) 1);
    }
}
