package com.example.reservation.domain.theater.model;

import static com.example.reservation.domain.theater.model.TheaterMapper.*;

import com.example.reservation.domain.theater.model.dto.SeatDto;
import com.example.reservation.domain.theater.model.entity.Seat;

public class SeatMapper {
	public static Seat toSeat(SeatDto seatDto) {
		return new Seat(seatDto.getId(), seatDto.getPosition(), toTheaterNoSeats(seatDto.getTheaterDto()));
	}

	public static SeatDto toSeatDto(Seat seat) {
		return new SeatDto(seat.getId(), seat.getPosition(), toTheaterDtoNoSeat(seat.getTheater()));
	}
}
