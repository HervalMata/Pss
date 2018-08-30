package com.herval.checkin.controller;

import com.herval.checkin.component.CheckinComponent;
import com.herval.checkin.model.CheckInRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * Criado Por Herval Mata em 30/08/2018
 */
@RestController
@CrossOrigin
@RequestMapping("/checkin")
public class CheckInController {

    CheckinComponent checkinComponent;

    @Autowired
    public CheckInController(CheckinComponent checkinComponent) {
        this.checkinComponent = checkinComponent;
    }

    @RequestMapping("/get/{id}")
    CheckInRecord getCheckIn(@PathVariable long id){
        return checkinComponent.getCheckInRecord(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    long checkIn(@RequestBody CheckInRecord checkIn){
        return checkinComponent.checkIn(checkIn);
    }
}
