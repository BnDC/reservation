package com.example.reservation.domain.reservation.model;

import static com.example.reservation.domain.movie.model.ScheduleMapper.*;
import static com.example.reservation.domain.reservation.model.ReservationMapper.*;
import static com.example.reservation.domain.theater.model.SeatMapper.*;

import com.example.reservation.domain.reservation.model.dto.ReservationItemDto;
import com.example.reservation.domain.reservation.model.dto.TicketDto;
import com.example.reservation.domain.reservation.model.entity.ReservationItem;
import com.example.reservation.domain.reservation.model.entity.Ticket;

public class ReservationItemMapper {
	public static ReservationItemDto toReservationItemDto(ReservationItem reservationItems) {
		return new ReservationItemDto(
				reservationItems.getId(),
				toReservationDto(reservationItems.getReservation()),
				toTicketDto(reservationItems.getTicket()),
				reservationItems.getTicketType(),
				reservationItems.getPrice()
		);
	}

	private static TicketDto toTicketDto(Ticket ticket) {
		return new TicketDto(
				ticket.getId(),
				toScheduleDto(ticket.getSchedule()),
				toSeatDto(ticket.getSeat()),
				ticket.isReserved()
		);
	}
}
