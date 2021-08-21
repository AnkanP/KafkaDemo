package com.example.kafkademo.controller;

import com.example.kafkademo.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaRestController {

KafkaProducerService kafkaProducerService;

//constructor injection
@Autowired
    public KafkaRestController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/publish")
    public void sendMessageToKafka(@RequestParam("message") String message){
kafkaProducerService.sendMessage(message);
    }
}
