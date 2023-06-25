package com.example.reservation.domain.reservation.model;

import com.example.reservation.domain.movie.model.dto.ScheduleDto;
import com.example.reservation.domain.theater.model.dto.SeatDto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TicketDto {
	private Long id;
	private ScheduleDto scheduleDto;
	private SeatDto seatDto;
	private boolean isReserved;

	public TicketDto(Long id, ScheduleDto scheduleDto, SeatDto seatDto, boolean isReserved) {
		this.id = id;
		this.scheduleDto = scheduleDto;
		this.seatDto = seatDto;
		this.isReserved = isReserved;
	}
}
