package com.example.reservation.domain.reservation.model;

import com.example.reservation.domain.movie.model.entity.Schedule;
import com.example.reservation.domain.theater.model.entity.Seat;

import lombok.Getter;

@Getter
public class TicketCreateRequest {
	private Schedule schedule;
	private Seat seat;

	public TicketCreateRequest(Schedule schedule, Seat seat) {
		this.schedule = schedule;
		this.seat = seat;
	}
}
