package com.example.reservation.domain.movie.model;

import static com.example.reservation.domain.movie.model.MovieMapper.*;
import static com.example.reservation.domain.theater.model.TheaterMapper.*;

import com.example.reservation.domain.movie.model.dto.ScheduleCreateRequest;
import com.example.reservation.domain.movie.model.dto.ScheduleDto;
import com.example.reservation.domain.movie.model.entity.Movie;
import com.example.reservation.domain.movie.model.entity.Schedule;
import com.example.reservation.domain.theater.model.entity.Theater;

public class ScheduleMapper {
	public static Schedule toSchedule(Theater theater, Movie movie, ScheduleCreateRequest scheduleCreateRequest) {
		return new Schedule(
				theater,
				movie,
				scheduleCreateRequest.getStartTime(),
				scheduleCreateRequest.getEndTime()
		);
	}

	public static ScheduleDto toScheduleDto(Schedule schedule) {
		return new ScheduleDto(
				schedule.getId(),
				schedule.getPrice(),
				schedule.getStartTime(),
				schedule.getEndTime(),
				toTheaterDto(schedule.getTheater()),
				toMovieDto(schedule.getMovie())
		);
	}
}
