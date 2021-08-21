package com.example.kafkademo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);
    @Value(value="${kafka.mytopic.name}")




    // Can directly pass the topic name and group id from the properties file
    @KafkaListener(topics = "${kafka.mytopic.name}", groupId = "${kafka.myconsumer.groupid}")
    public void consumeMessage(String msg) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", msg));

    }

}
