package com.example.reservation.domain.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation.domain.reservation.model.entity.ReservationItem;

public interface ReservationItemRepository extends JpaRepository<ReservationItem, Long> {
}
