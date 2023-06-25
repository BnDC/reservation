package com.example.reservation.domain.reservation.repository;

import static javax.persistence.LockModeType.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import com.example.reservation.domain.reservation.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
	@Lock(value = PESSIMISTIC_WRITE)
	@Override
	List<Ticket> findAllById(Iterable<Long> longs);
}

