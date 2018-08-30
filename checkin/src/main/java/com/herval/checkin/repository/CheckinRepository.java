package com.herval.checkin.repository;

import com.herval.checkin.model.CheckInRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Criado Por Herval Mata em 30/08/2018
 */
public interface CheckinRepository extends JpaRepository<CheckInRecord, Long> {
}
