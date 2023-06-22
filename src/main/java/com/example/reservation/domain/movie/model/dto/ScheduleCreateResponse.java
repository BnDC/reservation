package com.example.reservation.domain.movie.model.dto;

import lombok.Getter;

@Getter
public class ScheduleCreateResponse {
	private Long scheduleId;

	public ScheduleCreateResponse(Long scheduleId) {
		this.scheduleId = scheduleId;
	}
}
