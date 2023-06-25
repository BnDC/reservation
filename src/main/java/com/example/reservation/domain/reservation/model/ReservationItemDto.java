package com.example.reservation.domain.reservation.model;

import lombok.Getter;

@Getter
public class ReservationItemDto {
	private Long id;
	private ReservationDto reservationDto;
	private TicketDto ticketDto;
	private TicketType ticketType;
	private int price;

	public ReservationItemDto(Long id, ReservationDto reservationDto, TicketDto ticketDto, TicketType ticketType,
			int price) {
		this.id = id;
		this.reservationDto = reservationDto;
		this.ticketDto = ticketDto;
		this.ticketType = ticketType;
		this.price = price;
	}
}
