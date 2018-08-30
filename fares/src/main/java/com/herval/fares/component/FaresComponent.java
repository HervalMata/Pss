package com.herval.fares.component;

import com.herval.fares.model.Fare;
import com.herval.fares.repository.FareRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * Criado Por Herval Mata em 30/08/2018
 */
@Component
public class FaresComponent {

    private static final Logger logger = LoggerFactory.getLogger(FaresComponent.class);

    FareRepository fareRepository;

    @Autowired
    public FaresComponent(FareRepository fareRepository) {
        this.fareRepository = fareRepository;
    }

    public Fare getFare(String flightNumber, String flighDate) {
        logger.info("Looking for fares flightNumber " + flightNumber + " flightDate " + flighDate);
        return fareRepository.getFareByFlightNumberAndFlightDate(flightNumber, flighDate);
    }
}
