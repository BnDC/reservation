package com.example.reservation.domain.theater.model.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;

@Getter
public class MultiplexDto {
	private Long id;
	private String name;
	private LocalDate openingDay;
	private LocalTime startTime;
	private LocalTime endTime;

	public MultiplexDto(
			Long id, String name, LocalDate openingDay,
			LocalTime startTime, LocalTime endTime
	) {
		this.id = id;
		this.name = name;
		this.openingDay = openingDay;
		this.startTime = startTime;
		this.endTime = endTime;
	}
}
