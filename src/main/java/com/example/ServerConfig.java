package com.example;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;


@Configuration
public class ServerConfig
{
    private String bootstrapServers = "localhost:9092";


    @Bean
    public Map<String, Object> producerConfigs()
    {
        Map<String, Object> props = new HashMap<>();
        props.put( ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers );
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 100000);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 100);
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put( ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class );
        props.put( ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class );
        return props;
    }


    @Bean
    public ProducerFactory<String, String> producerFactory()
    {
        return new DefaultKafkaProducerFactory<>( producerConfigs() );
    }


    @Bean
    public KafkaTemplate<String, String> kafkaTemplate()
    {
        return new KafkaTemplate<>( producerFactory() );
    }

}
