package com.example.reservation.domain.movie.model.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class ScheduleGetAllResponse {
	List<ScheduleDto> scheduleDtos;

	public ScheduleGetAllResponse(List<ScheduleDto> scheduleDtos) {
		this.scheduleDtos = scheduleDtos;
	}
}
