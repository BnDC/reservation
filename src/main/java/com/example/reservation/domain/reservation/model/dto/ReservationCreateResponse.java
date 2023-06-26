package com.example.reservation.domain.reservation.model.dto;

import lombok.Getter;

@Getter
public class ReservationCreateResponse {
	private Long ReservationId;

	public ReservationCreateResponse(Long reservationId) {
		ReservationId = reservationId;
	}
}
