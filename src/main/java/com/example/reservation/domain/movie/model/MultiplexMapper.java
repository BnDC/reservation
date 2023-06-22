package com.example.reservation.domain.movie.model;

import com.example.reservation.domain.theater.model.dto.MultiplexDto;
import com.example.reservation.domain.theater.model.entity.Multiplex;

public class MultiplexMapper {
	public static Multiplex toMultiplex(MultiplexDto multiplexDto) {
		return new Multiplex(
				multiplexDto.getId(),
				multiplexDto.getName(),
				multiplexDto.getOpeningDay(),
				multiplexDto.getStartTime(),
				multiplexDto.getEndTime()
		);
	}

	public static MultiplexDto toMultiplexDto(Multiplex multiplex) {
		return new MultiplexDto(
				multiplex.getId(),
				multiplex.getName(),
				multiplex.getOpeningDay(),
				multiplex.getStartTime(),
				multiplex.getEndTime()
		);
	}
}
