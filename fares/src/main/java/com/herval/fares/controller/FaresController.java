package com.herval.fares.controller;

import com.herval.fares.component.FaresComponent;
import com.herval.fares.model.Fare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * Criado Por Herval Mata em 30/08/2018
 */
@CrossOrigin
@RestController
@RequestMapping("/fares")
public class FaresController {

    FaresComponent faresComponent;

    @Autowired
    public FaresController(FaresComponent faresComponent) {
        this.faresComponent = faresComponent;
    }

    @RequestMapping("/get")
    Fare getFare(@RequestParam(value = "flightNumber") String flightNumber,
                 @RequestParam(value = "flightDate") String flighDate){
        return faresComponent.getFare(flightNumber, flighDate);
    }
}
