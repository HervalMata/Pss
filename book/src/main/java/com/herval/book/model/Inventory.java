package com.herval.book.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Criado Por Herval Mata em 30/08/2018
 */
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String flightNumber;
    String flightDate;
    int available;

    public Inventory() {
    }

    public Inventory(String flightNumber, String flightDate, int available) {
        this.flightNumber = flightNumber;
        this.flightDate = flightDate;
        this.available = available;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Inventory [id=" + id + ", flightNumber=" + flightNumber + ", flightDate=" + flightDate + ", available="
                + available + "]";
    }

    public boolean isAvailable(int size) {
        return true;
    }
}
