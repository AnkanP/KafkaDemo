package com.example.kafkademo.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;


import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Autowired
    private Environment environment;

    public ConsumerFactory<String, String> consumerFactory(){
        Map<String,Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,environment.getProperty("kafka.mybootstrap.address"));
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,environment.getProperty("kafka.producer.key.serializer"));
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,environment.getProperty("kafka.producer.value.serializer"));
        props.put(ConsumerConfig.GROUP_ID_CONFIG, environment.getProperty("kafka.consumer.groupid"));
        return new DefaultKafkaConsumerFactory<>(props);
    }



}
