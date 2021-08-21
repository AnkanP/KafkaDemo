package com.example.kafkademo.service;

import com.example.kafkademo.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
    @Value(value="${kafka.mytopic.name}")
    private String kafkaTopicName;

    //KafkaTemplate provides convenient methods to send messages to topics:
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg){
        logger.info(String.format("#### -> Producing message -> %s", msg));
        kafkaTemplate.send(kafkaTopicName, msg);

    }


}
