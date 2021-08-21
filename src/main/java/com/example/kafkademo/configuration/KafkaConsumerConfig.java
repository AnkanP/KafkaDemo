package com.example.kafkademo.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;


import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Autowired
    private Environment environment;

    public ConsumerFactory<String, String> consumerFactory(){
        Map<String,Object> props = new HashMap<>();
        //props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,environment.getProperty("kafka.mybootstrap.address"));
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"b-2.demo-cluster-1.7x9lx9.c17.kafka.us-east-1.amazonaws.com:9092, b-1.demo-cluster-1.7x9lx9.c17.kafka.us-east-1.amazonaws.com:9092");

//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,environment.getProperty("kafka.myconsumer.key.deserializer"));
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,environment.getProperty("kafka.myconsumer.value.deserializer"));

        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);

        props.put(ConsumerConfig.GROUP_ID_CONFIG, environment.getProperty("kafka.myconsumer.groupid"));
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props);
    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String>
    kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
