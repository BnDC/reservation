package com.example.reservation.domain.reservation.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ReservationItemCreateRequest {
	@NotNull
	@Positive
	private Long ticketId;

	@NotNull
	private TicketType ticketType;
}