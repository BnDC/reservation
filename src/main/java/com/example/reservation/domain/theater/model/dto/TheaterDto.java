package com.example.reservation.domain.theater.model.dto;

import java.util.List;

import com.example.reservation.domain.theater.model.SeatDto;
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
	private Multiplex multiPlex;
	private List<SeatDto> seats;

	public TheaterDto(
			Long id, String name, TheaterType theaterType, Multiplex multiPlex, List<SeatDto> seatDtos
	) {
		this.id = id;
		this.name = name;
		this.theaterType = theaterType;
		this.multiPlex = multiPlex;
		this.seats = seatDtos;
	}
}
