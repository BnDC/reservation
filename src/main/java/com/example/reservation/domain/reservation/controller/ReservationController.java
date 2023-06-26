package com.example.reservation.domain.reservation.controller;

import static org.springframework.http.HttpStatus.*;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservation.domain.reservation.model.dto.ReservationCreateRequest;
import com.example.reservation.domain.reservation.model.dto.ReservationCreateResponse;
import com.example.reservation.domain.reservation.service.ReservationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ReservationController {

	private final ReservationService reservationService;

	@PostMapping("/reservations/new")
	public ResponseEntity<ReservationCreateResponse> test(
			@Validated @RequestBody ReservationCreateRequest reservationCreateRequest
	) {
		Long reservationId = reservationService.createReservation(reservationCreateRequest);
		return new ResponseEntity<>(new ReservationCreateResponse(reservationId), CREATED);
	}
}
