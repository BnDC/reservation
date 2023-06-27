package com.example.reservation.domain.theater.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@ApiModel(description = "상영관 조회 응답")
@Getter
public class TheaterGetResponse {
	private TheaterDto theaterDto;

	public TheaterGetResponse(TheaterDto theaterDto) {
		this.theaterDto = theaterDto;
	}
}
