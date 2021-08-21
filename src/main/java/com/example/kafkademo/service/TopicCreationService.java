package com.example.kafkademo.service;

import org.apache.kafka.clients.admin.ListTopicsOptions;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.common.PartitionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class TopicCreationService {
    @Autowired
    private ConsumerFactory<String, String> consumerFactory;
    NewTopic newTopic;


    @Autowired
    public TopicCreationService(NewTopic newTopic) {
        this.newTopic = newTopic;
    }


    public Set<String> getTopics() {
        try (Consumer<String, String> consumer =
                     consumerFactory.createConsumer()) {
            Map<String, List<PartitionInfo>> map = consumer.listTopics();
            return map.keySet();
        }
    }


}
