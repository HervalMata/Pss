package com.herval.book.controller;

import com.herval.book.component.BookingComponent;
import com.herval.book.component.BookingStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/*
 * Criado Por Herval Mata em 30/08/2018
 */
@Component
public class Receiver {

    BookingComponent bookingComponent;

    @Autowired
    public Receiver() {

    }

    @ServiceActivator(inputChannel = BookingSink.CHECKINQ)
    public void accept(long bookingId){
        bookingComponent.updateStatus(BookingStatus.CHECKED_IN, bookingId);
    }

    interface BookingSink {
        public static String CHECKINQ = "checkInQ";
        @Input("chevkInQ")
        public MessageChannel checkInQ();
    }

}
