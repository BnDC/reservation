package com.example.reservation.domain.reservation.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.example.reservation.domain.reservation.model.type.TicketType;

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
