package com.herval.checkin.component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/*
 * Criado Por Herval Mata em 30/08/2018
 */
@EnableBinding(Sender.CheckInSource.class)
@Component
public class Sender {

    public Sender() {
    }

    @Output(CheckInSource.CHECKING)
    @Autowired
    private MessageChannel messageChannel;

    public void send(Object message){
        messageChannel.send(MessageBuilder.withPayload(message).build());
    }

    interface CheckInSource{
        public static String CHECKING = "checkInQ";
        @Output("checkInQ")
        public MessageChannel checkInQ();
    }
}
