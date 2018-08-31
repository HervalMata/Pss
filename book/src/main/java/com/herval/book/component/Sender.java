package com.herval.book.component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
 * Criado Por Herval Mata em 31/08/2018
 */
@Component
public class Sender {

    RabbitMessagingTemplate template;

    @Autowired
    public Sender(RabbitMessagingTemplate template) {
        this.template = template;
    }

    @Bean
    Queue queue(){
        return new Queue("SearchQ", false);
    }

    @Bean
    Queue queue1(){
        return new Queue("CheckINhQ", false);
    }

    public void send(Object message) {
        template.convertAndSend("SearchQ", message);
    }
}
