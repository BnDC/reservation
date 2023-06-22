package com.example.reservation.domain.movie.model.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
public class ScheduleCreateRequest {
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime startTime;

	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime endTime;

	@NotNull
	@Positive
	private Long theaterId;

	@NotNull
	@Positive
	private Long movieId;
}
