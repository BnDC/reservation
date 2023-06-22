package com.example.reservation.domain.movie.model.dto;

import java.time.LocalDateTime;

import com.example.reservation.domain.theater.model.dto.TheaterDto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ScheduleDto {
	private Long id;
	private int price;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private TheaterDto theaterDto;
	private MovieDto movieDto;

	public ScheduleDto(Long id, int price, LocalDateTime startTime, LocalDateTime endTime, TheaterDto theaterDto,
			MovieDto movieDto) {
		this.id = id;
		this.price = price;
		this.startTime = startTime;
		this.endTime = endTime;
		this.theaterDto = theaterDto;
		this.movieDto = movieDto;
	}
}
