package com.example.reservation.domain.reservation.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;

@Getter
public class ReservationCreateRequest {
	@NotEmpty
	List<ReservationItemCreateRequest> reservationItemCreateRequests;
}
