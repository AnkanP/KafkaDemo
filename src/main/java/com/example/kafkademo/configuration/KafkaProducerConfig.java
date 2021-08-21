package com.example.kafkademo.configuration;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    // Different implementation instead of using @Value. use the environment class to read the properties file
    @Autowired
    private Environment environment;

    //Step1: Create a producer factory method. Producer factory will create producer instances
@Bean
public ProducerFactory<String, String> producerFactory(){

    Map<String,Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,environment.getProperty("kafka.mybootstrap.address"));
    //props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,environment.getProperty("kafka.myproducer.key.serializer"));
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    //props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,environment.getProperty("kafka.myproducer.value.serializer"));
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);

    return new DefaultKafkaProducerFactory<>(props);
}


    //step2: Create kafka template which wraps a producer instance and provides methods for consuming or sending messages
    @Bean
public KafkaTemplate<String,String > kafkaTemplate(){

    return new KafkaTemplate<>(producerFactory());
}

}
