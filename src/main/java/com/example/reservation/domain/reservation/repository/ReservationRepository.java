package com.example.reservation.domain.reservation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.reservation.domain.reservation.model.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	@Query(value = "select r from Reservation r join fetch r.reservationItems")
	Optional<Reservation> findReservationByIdWithReservationItems(Long id);
}
