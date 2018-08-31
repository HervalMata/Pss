package com.herval.book.component;

import com.herval.book.model.BookingRecord;
import com.herval.book.model.Inventory;
import com.herval.book.model.Passenger;
import com.herval.book.repository.BookingRepository;
import com.herval.book.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Criado Por Herval Mata em 30/08/2018
 */
@Component
public class BookingComponent {

    private static final Logger logger = LoggerFactory.getLogger(BookingComponent.class);
    private static final String FareURL = "http://localhost:8082";

    BookingRepository bookingRepository;
    InventoryRepository inventoryRepository;

    private WebClient webClient;
    Sender sender;

    @Autowired
    public BookingComponent(BookingRepository bookingRepository, InventoryRepository inventoryRepository, WebClient webClient, Sender sender) {
        this.bookingRepository = bookingRepository;
        this.inventoryRepository = inventoryRepository;
        this.webClient = webClient;
        this.sender = sender;
    }

    public long book(BookingRecord record) {
        logger.info("calling fares to get fare");
        validateFareReactively(record);
        logger.info("calling inventory to get inventory");
        Inventory inventory = inventoryRepository.findByFlightNumberAndFlightDate(record.getFlightNumber(), record.getFlightDate());
        if (!inventory.isAvailable(record.getPassangers().size())){
            throw new BookingException("No more seats avaialble");
        }
        logger.info("successfully checked inventory" + inventory);
        logger.info("calling inventory to update inventory");
        inventory.setAvailable(inventory.getAvailable() - record.getPassangers().size());
        inventoryRepository.saveAndFlush(inventory);
        logger.info("sucessfully updated inventory");
        record.setStatus(BookingStatus.BOOKKING_CONFIRMED);
        Set<Passenger> passengers = record.getPassangers();
        passengers.forEach(passenger -> passenger.setBookingRecord(record));
        record.setBookingDate(new Date());
        long id = bookingRepository.save(record).getId();
        logger.info("Successfully saved booking");
        logger.info("sending a booking event");
        Map<String, Object> bookingDetails = new HashMap<String, Object>();
        bookingDetails.put("FLIGHT_NUMBER", record.getFlightNumber());
        bookingDetails.put("FLIGHT_DATE", record.getFlightDate());
        bookingDetails.put("NEW_INVENTORY", record.getBookableInventory());
        sender.send(bookingDetails);
        logger.info("booking event successfully delivered " + bookingDetails);
        return id;
    }

    private void validateFareReactively(BookingRecord record) {
        Mono<Fare> result = webClient.get().uri("/fares/get?flightNumber= " +
                record.getFlightNumber() + " &flightDate = " + record.getFlightDate())
                .accept(MediaType.APPLICATION_JSON).exchange().flatMap(response ->
                        response.bodyToMono(Fare.class));
        result.subscribe(fare -> checkFare(record.getFare(), fare.getFare()));
    }

    public BookingRecord getBooking(long id) {
        return bookingRepository.findById(new Long(id)).get();
    }

    public void updateStatus(String status, long bookingId) {
        BookingRecord record = bookingRepository.findById(new Long(bookingId)).get();
        record.setStatus(status);
    }

    private void checkFare(String requestedFare, String actualfare){
        logger.info("calling fares to get fare (reactively collected) " + actualfare);
        if (!requestedFare.equals(actualfare)) throw new BookingException("fare is tampered");
    }
}
