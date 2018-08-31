package com.herval.book.repository;

import com.herval.book.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Criado Por Herval Mata em 30/08/2018
 */
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Inventory findByFlightNumberAndFlightDate(String flightNumber, String flightDate);
}
