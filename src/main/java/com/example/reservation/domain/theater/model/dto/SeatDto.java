package com.example.reservation.domain.theater.model.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SeatDto {
	String position;
	String theaterName;

	public SeatDto(String position, String theaterName) {
		this.position = position;
		this.theaterName = theaterName;
	}
}
