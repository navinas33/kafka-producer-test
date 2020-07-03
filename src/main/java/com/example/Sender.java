package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;


@Configuration
public class Sender
{
    private static final Logger LOG = LoggerFactory.getLogger( Sender.class );

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void send( String topic, String key, String message )
    {
        LOG.info( "sending message='{}' to topic='{}'", message, topic );
        kafkaTemplate.send( topic, key, message );
    }
}
