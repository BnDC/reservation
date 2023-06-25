package com.example.reservation.domain.theater.model.dto;

import java.util.List;

import com.example.reservation.domain.theater.model.type.TheaterType;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TheaterDto {
	private Long id;
	private String name;
	private TheaterType theaterType;
	private MultiplexDto multiplexDto;
	private List<SeatDto> seats;

	public TheaterDto(
			Long id, String name, TheaterType theaterType, MultiplexDto multiplexDto
	) {
		this.id = id;
		this.name = name;
		this.theaterType = theaterType;
		this.multiplexDto = multiplexDto;
	}

	public TheaterDto(
			Long id, String name, TheaterType theaterType, MultiplexDto multiplexDto, List<SeatDto> seatDtos
	) {
		this(id, name, theaterType, multiplexDto);
		this.seats = seatDtos;
	}
}
