package com.herval.search.component;

import com.herval.search.controller.SearchQuery;
import com.herval.search.model.Flight;
import com.herval.search.model.Inventory;
import com.herval.search.repository.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*
 * Criado Por Herval Mata em 30/08/2018
 */
@Component
public class SearchComponent {

    private FlightRepository flightRepository;
    private static final Logger logger = LoggerFactory.getLogger(SearchComponent.class);

    @Autowired
    public SearchComponent(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> search(SearchQuery query){
        List<Flight> flights = flightRepository.findByOriginAndDestinationAndFlightDate(query.getOrigin(),
                query.getDestination(), query.getFlightDate());
        List<Flight> searchResult = new ArrayList<Flight>();
        searchResult.addAll(flights);
        flights.forEach(flight -> {
            flight.getFares();
            int inv = flight.getInventory().getCount();
            if (inv < 0){
                searchResult.remove(flight);
            }
        });
        return searchResult;
    }

    public void updateInventory(String flightNumber, String flightDate, int inventory){
        logger.info("Updating inventory for flight " + flightNumber
                    + " inventory " + inventory);
        Flight flight = flightRepository.findByFlightNumberAndFlightDate(flightNumber, flightDate);
        Inventory inv = flight.getInventory();
        inv.setCount(inventory);
        flightRepository.save(flight);
    }
}
