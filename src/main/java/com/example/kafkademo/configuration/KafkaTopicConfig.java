package com.example.kafkademo.configuration;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.requests.DeleteTopicsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {



    @Value(value="${kafka.mybootstrap.address}")
    private String bootstrapAddress;
    @Value(value="${kafka.mytopic.name}")
    private String kafkaTopicName;

    //A KafkaAdmin bean is responsible for creating new topics in our broker.
    // //With Spring Boot, a KafkaAdmin bean is automatically registered.
    // However for example we will show how to create a kafka admin bean

    @Bean
    public KafkaAdmin kafkaAdmin(){
        // The below can either be a map or a properties object
        Map<String,Object> configs = new HashMap<>();

        // The adminclient config class contains constants for config properties
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);

        return new KafkaAdmin(configs);
    }


    @Bean
    public NewTopic createTopic(){

        //return new NewTopic("crawler-test",1,(short) 1);
        //or we can use topic builder (from spring framework)
        //return TopicBuilder.name(kafkaTopicName)
         //       .partitions(1)
          //      .replicas(1)
           //     .build();
      //return new NewTopic(kafkaTopicName,1,(short)1);
        return new NewTopic(kafkaTopicName,1,(short) 1);
   }




}
