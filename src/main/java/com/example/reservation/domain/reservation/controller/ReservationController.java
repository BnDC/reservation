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

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@Api(tags = "예약 컨트롤러")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ReservationController {

	private final ReservationService reservationService;

	@Operation(summary = "예매 등록", description = "예매를 위한 api")
	@PostMapping("/reservations/new")
	public ResponseEntity<ReservationCreateResponse> createReservation(
			@Validated @RequestBody ReservationCreateRequest reservationCreateRequest
	) {
		Long reservationId = reservationService.createReservation(reservationCreateRequest);
		return new ResponseEntity<>(new ReservationCreateResponse(reservationId), CREATED);
	}
}
