package com.example.reservation.domain.theater.model;

import java.util.stream.Collectors;

import com.example.reservation.domain.theater.model.dto.TheaterCreateRequest;
import com.example.reservation.domain.theater.model.dto.TheaterDto;
import com.example.reservation.domain.theater.model.entity.Multiplex;
import com.example.reservation.domain.theater.model.entity.Theater;

public class TheaterMapper {
	public static Theater toTheater(TheaterCreateRequest theaterCreateRequest, Multiplex multiPlex) {
		return new Theater(
				theaterCreateRequest.getName(),
				theaterCreateRequest.getTheaterType(),
				multiPlex
		);
	}

	public static TheaterDto toTheaterDto(Theater theater) {
		return new TheaterDto(theater.getId(),
				theater.getName(),
				theater.getTheaterType(),
				theater.getMultiplex(),
				theater.getSeats()
						.stream()
						.map(SeatMapper::toSeatDto)
						.collect(Collectors.toList())
		);
	}
}
