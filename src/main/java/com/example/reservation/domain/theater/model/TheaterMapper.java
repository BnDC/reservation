package com.example.reservation.domain.theater.model;

import static com.example.reservation.domain.movie.model.MultiplexMapper.*;
import static java.util.stream.Collectors.*;

import com.example.reservation.domain.theater.model.dto.TheaterCreateRequest;
import com.example.reservation.domain.theater.model.dto.TheaterDto;
import com.example.reservation.domain.theater.model.entity.Multiplex;
import com.example.reservation.domain.theater.model.entity.Theater;

public class TheaterMapper {
	public static Theater toTheaterNoSeats(TheaterCreateRequest theaterCreateRequest, Multiplex multiPlex) {
		return new Theater(
				theaterCreateRequest.getName(),
				theaterCreateRequest.getTheaterType(),
				multiPlex
		);
	}

	public static Theater toTheaterNoSeats(TheaterDto theaterDto) {
		return new Theater(
				theaterDto.getId(),
				theaterDto.getName(),
				theaterDto.getTheaterType(),
				toMultiplex(theaterDto.getMultiplexDto())
		);
	}

	public static Theater toTheater(TheaterDto theaterDto) {
		return new Theater(
				theaterDto.getId(),
				theaterDto.getName(),
				theaterDto.getTheaterType(),
				toMultiplex(theaterDto.getMultiplexDto()),
				theaterDto.getSeats()
						.stream()
						.map(SeatMapper::toSeat)
						.collect(toList())
		);
	}

	public static TheaterDto toTheaterDto(Theater theater) {
		return new TheaterDto(theater.getId(),
				theater.getName(),
				theater.getTheaterType(),
				toMultiplexDto(theater.getMultiplex()),
				theater.getSeats()
						.stream()
						.map(SeatMapper::toSeatDto)
						.collect(toList())
		);
	}

	public static TheaterDto toTheaterDtoNoSeat(Theater theater) {
		return new TheaterDto(theater.getId(),
				theater.getName(),
				theater.getTheaterType(),
				toMultiplexDto(theater.getMultiplex())
		);
	}
}
