package com.herval.website.model;

import java.util.List;

/*
 * Criado Por Herval Mata em 30/08/2018
 */
public class UIData {

    private SearchQuery searchQuery;
    private List<Flight> flights;
    private Flight selectedFlight;
    private Passenger passenger;
    private String bookingId;

    public SearchQuery getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(SearchQuery searchQuery) {
        this.searchQuery = searchQuery;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public Flight getSelectedFlight() {
        return selectedFlight;
    }

    public void setSelectedFlight(Flight selectedFlight) {
        this.selectedFlight = selectedFlight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void getSelectedFlight(Flight flight) {
    }
}
