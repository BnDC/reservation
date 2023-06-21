package com.example.reservation.domain.theater.model;

import com.example.reservation.domain.theater.model.dto.SeatDto;
import com.example.reservation.domain.theater.model.entity.Seat;

public class SeatMapper {

	public static SeatDto toSeatDto(Seat seat) {
		return new SeatDto(seat.getPosition(), seat.getTheater().getName());
	}
}
