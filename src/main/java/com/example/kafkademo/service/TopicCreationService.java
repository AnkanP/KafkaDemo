package com.example.kafkademo.service;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicCreationService {

    NewTopic newTopic;

    @Autowired
    public TopicCreationService(NewTopic newTopic) {
        this.newTopic = newTopic;
    }


}
