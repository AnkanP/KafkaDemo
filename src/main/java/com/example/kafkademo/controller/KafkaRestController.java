package com.example.kafkademo.controller;

import com.example.kafkademo.models.TopicCreation;
import com.example.kafkademo.service.KafkaProducerService;
import com.example.kafkademo.service.TopicCreationService;
import org.apache.kafka.clients.admin.ListTopicsOptions;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaRestController {

KafkaProducerService kafkaProducerService;

    @Autowired
    KafkaAdmin adminClient;
    @Autowired
    TopicCreationService topicCreationService;

//constructor injection
@Autowired
    public KafkaRestController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/publish")
    public void sendMessageToKafka(@RequestParam("message") String message){
kafkaProducerService.sendMessage(message);
    }

    @PostMapping("/create")
    public String createTopics(@RequestBody TopicCreation topicCreation){

        //NewTopic newTopic = new NewTopic("abc",1, (short) 1);

        TopicCreationService topicCreationService
                = new TopicCreationService(
                        new NewTopic(topicCreation.getTopicName(),
                                topicCreation.getPartitions(),
                                (short) topicCreation.getReplicas()));

    return "topic created successfully: " + topicCreation.getTopicName();

    }

    @GetMapping("/list")
    public String listTopics(){


        return topicCreationService.getTopics().toString();
    }

}
