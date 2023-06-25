package com.example.reservation.domain.theater.model.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SeatDto {
	private Long id;
	String position;
	TheaterDto theaterDto;

	public SeatDto(String position, TheaterDto theaterDto) {
		this.position = position;
		this.theaterDto = theaterDto;
	}

	public SeatDto(Long id, String position, TheaterDto theaterDto) {
		this(position, theaterDto);
		this.id = id;
	}
}
