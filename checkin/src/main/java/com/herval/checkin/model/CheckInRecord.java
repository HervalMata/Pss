package com.herval.checkin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/*
 * Criado Por Herval Mata em 30/08/2018
 */
@Entity
public class CheckInRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String lastName;
    String firstName;
    String seatNumber;
    Date checkInTime;
    String flightNumber;
    String flightDate;
    long bookingId;

    public CheckInRecord() {
    }

    public CheckInRecord(String lastName, String firstName, String seatNumber, Date checkInTime, String flightNumber, String flightDate, long bookingId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.seatNumber = seatNumber;
        this.checkInTime = checkInTime;
        this.flightNumber = flightNumber;
        this.flightDate = flightDate;
        this.bookingId = bookingId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstNumber(String firstName) {
        this.firstName = firstName;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlghtNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "CheckInRecord [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", seatNumber="
                + seatNumber + ", checkInTime=" + checkInTime + ", flightNumber=" + flightNumber + ", flightDate="
                + flightDate + "]";
    }
}