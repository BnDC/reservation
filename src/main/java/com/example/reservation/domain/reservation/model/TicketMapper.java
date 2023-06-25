package com.example.reservation.domain.reservation.model;

import static com.example.reservation.domain.movie.model.ScheduleMapper.*;
import static com.example.reservation.domain.theater.model.SeatMapper.*;

public class TicketMapper {
	public static Ticket toTicket(TicketDto ticketDto) {
		return new Ticket(
				ticketDto.getId(),
				toSchedule(ticketDto.getScheduleDto()),
				toSeat(ticketDto.getSeatDto())
		);
	}

	public static TicketDto toTicketDto(Ticket ticket) {
		return new TicketDto(
				ticket.getId(),
				toScheduleDto(ticket.getSchedule()),
				toSeatDto(ticket.getSeat()),
				ticket.isReserved()
		);
	}
}
