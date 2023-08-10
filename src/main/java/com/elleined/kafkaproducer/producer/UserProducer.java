package com.elleined.kafkaproducer.producer;

import com.elleined.kafkaproducer.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserProducer {

    @Value("${spring.kafka.topic.userTopic}")
    private String USER_TOPIC;

    private final KafkaTemplate<String, User> kafkaTemplate;

    public void publishUser(User user) {
        kafkaTemplate.send(USER_TOPIC, user);
        log.debug("User {} successfully sent in {} topic", user, USER_TOPIC);
    }
}
