package com.herval.book.repository;

import com.herval.book.model.BookingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Criado Por Herval Mata em 30/08/2018
 */
public interface BookingRepository extends JpaRepository<BookingRecord, Long> {
}
