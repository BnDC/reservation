package com.example.reservation.domain.member.model.dto;

import lombok.Getter;

@Getter
public class TheaterCreateResponse {
	private Long theaterId;
	public TheaterCreateResponse(Long theaterId) {
		this.theaterId = theaterId;
	}
}
