package com.herval.search.repository;

import com.herval.search.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 * Criado Por Herval Mata em 30/08/2018
 */
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByOriginAndDestinationAndFlightDate(String origin, String destination, String flightDate);

    Flight findByFlightNumberAndFlightDate(String flightNumber, String flightDate);
}
