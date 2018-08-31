package com.herval.book.controller;

import com.herval.book.component.BookingComponent;
import com.herval.book.component.BookingStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * Criado Por Herval Mata em 30/08/2018
 */
@Component
public class Receiver {

    BookingComponent bookingComponent;

    @Autowired
    public Receiver(BookingComponent bookingComponent) {
        this.bookingComponent = bookingComponent;
    }

    @RabbitListener(queues = "CheckINQ")
    public void processMessage(long bookingId){
        System.out.println(bookingId);
        bookingComponent.updateStatus(BookingStatus.CHECKED_IN, bookingId);
    }
}
