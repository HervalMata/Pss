package com.herval.book.controller;

import com.herval.book.component.BookingComponent;
import com.herval.book.model.BookingRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * Criado Por Herval Mata em 30/08/2018
 */
@RestController
@CrossOrigin
@RequestMapping("/booking")
public class BookingController {

    BookingComponent bookingComponent;

    @Autowired
    public BookingController(BookingComponent bookingComponent) {
        this.bookingComponent = bookingComponent;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    long book(@RequestBody BookingRecord record){
        System.out.println("Booking Request" + record);
        return bookingComponent.book(record);
    }

    @RequestMapping("/get/{id}")
    BookingRecord getBooking(@PathVariable long id){
        return bookingComponent.getBooking(id);
    }
}
