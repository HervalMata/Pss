package com.herval.search.component;

import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
 * Criado Por Herval Mata em 30/08/2018
 */
@Component
public class Receiver {

    SearchComponent searchComponent;

    @Autowired
    public Receiver(SearchComponent searchComponent){
        this.searchComponent = searchComponent;
    }

    @Bean
    Queue queue(){
        return new Queue("SearchQ", false);
    }

    @RabbitListener(queues = "SearchQ")
    public void processMessage(Map<String, Object> fare){
        System.out.println(fare);
        searchComponent.updateInventory((String) fare.get("FLIGHT_NUMBER"),
                (String) fare.get("FLIGHT_DATE"), (int)fare.get("NEW_INVENTORY"));
    }
}
