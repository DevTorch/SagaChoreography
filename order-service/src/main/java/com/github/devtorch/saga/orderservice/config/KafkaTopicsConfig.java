package com.github.devtorch.saga.orderservice.config;

import com.github.devtorch.saga.common.constants.CoreConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.Map;

@Configuration
public class KafkaTopicsConfig {

    @Bean
    NewTopic orderCreatedTopic() {
        return TopicBuilder.name(CoreConstants.ORDER_CREATED_TOPIC)
                .partitions(1)
                .replicas(2)
                .configs(Map.of("min.insync.replicas", "2"))
                .compact()
                .build();
    }

    @Bean
    NewTopic paymentTopic() {
        return TopicBuilder.name(CoreConstants.PAYMENT_TOPIC)
                .partitions(1)
                .replicas(2)
                .configs(Map.of("min.insync.replicas", "2"))
                .compact()
                .build();
    }
}
