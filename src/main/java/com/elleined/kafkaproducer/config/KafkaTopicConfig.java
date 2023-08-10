package com.elleined.kafkaproducer.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@Slf4j
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.userTopic}")
    private String userTopic;

    @Bean
    public NewTopic userTopic() {
        var newTopic = TopicBuilder.name(userTopic).build();
        log.debug("Topic with name of {} successfully created", userTopic);
        return newTopic;
    }
}
