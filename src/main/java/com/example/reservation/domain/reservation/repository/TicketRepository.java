package com.example.reservation.domain.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation.domain.reservation.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
