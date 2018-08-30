package com.herval.fares.repository;

import com.herval.fares.model.Fare;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Criado Por Herval Mata em 30/08/2018
 */
public interface FareRepository extends JpaRepository<Fare, Long> {
    Fare getFareByFlightNumberAndFlightDate(String flightNumber,
                                            String flightDate);
}
