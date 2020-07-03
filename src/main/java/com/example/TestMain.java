package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TestMain
    implements
    CommandLineRunner
{

    public static void main( String[] args )
    {
        SpringApplication.run( TestMain.class, args );
    }


    @Autowired
    private Sender sender;


    @Override
    public void run( String... strings ) throws Exception
    {
        String topic = "nbi.cm.changes.mo.";

        for( long i = 1; i <= 1000000; i++ )
        {

            String dn = "dummy_key";

            String msg = "dummy message in json";

            sender.send( topic, dn, msg );
        }

    }
}
