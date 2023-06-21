package com.example.reservation.domain.theater.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation.domain.theater.model.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
