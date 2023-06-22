package com.example.reservation.domain.theater.model.dto;

import java.util.List;

import com.example.reservation.domain.movie.model.MultiplexMapper;
import com.example.reservation.domain.theater.model.entity.Multiplex;
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
			Long id, String name, TheaterType theaterType, Multiplex multiPlex, List<SeatDto> seatDtos
	) {
		this.id = id;
		this.name = name;
		this.theaterType = theaterType;
		this.multiplexDto = MultiplexMapper.toMultiplexDto(multiPlex);
		this.seats = seatDtos;
	}
}
