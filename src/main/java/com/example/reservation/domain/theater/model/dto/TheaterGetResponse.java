package com.example.reservation.domain.theater.model.dto;

import com.example.reservation.domain.theater.model.dto.TheaterDto;

import lombok.Getter;

@Getter
public class TheaterGetResponse {
	private TheaterDto theaterDto;

	public TheaterGetResponse(TheaterDto theaterDto) {
		this.theaterDto = theaterDto;
	}
}
