package com.example.demo1.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class RabbitConfig {

    @Bean
    public Queue queue(){
        return new Queue("hello");
    }

}
