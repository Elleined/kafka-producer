package com.elleined.kafkaproducer.service;

import com.elleined.kafkaproducer.model.User;
import com.elleined.kafkaproducer.producer.UserProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserProducer userProducer;

    public User saveUser(User user) {
        userProducer.publishUser(user);
        return user;
    }
}
