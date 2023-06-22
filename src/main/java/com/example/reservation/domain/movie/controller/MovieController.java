package com.example.reservation.domain.movie.controller;

import static org.springframework.http.HttpStatus.*;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservation.domain.movie.model.dto.MovieCreateRequest;
import com.example.reservation.domain.movie.model.dto.MovieCreateResponse;
import com.example.reservation.domain.movie.model.dto.MovieDto;
import com.example.reservation.domain.movie.model.dto.MovieGetResponse;
import com.example.reservation.domain.movie.model.dto.ScheduleCreateRequest;
import com.example.reservation.domain.movie.model.dto.ScheduleCreateResponse;
import com.example.reservation.domain.movie.model.dto.ScheduleGetAllResponse;
import com.example.reservation.domain.movie.service.MovieService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MovieController {
	private final MovieService movieService;

	@PostMapping("/movies/new")
	public ResponseEntity<MovieCreateResponse> createMovie(
			@Validated @RequestBody MovieCreateRequest movieCreateRequest
	) {
		Long movieId = movieService.createMovie(movieCreateRequest);
		return new ResponseEntity<>(new MovieCreateResponse(movieId), CREATED);
	}

	@GetMapping("/movies/{movieId}")
	public ResponseEntity<MovieGetResponse> getMovie(@PathVariable Long movieId) {
		MovieDto movie = movieService.getMovie(movieId);
		return new ResponseEntity<>(new MovieGetResponse(movie), OK);
	}

	@PostMapping("/schedules/new")
	public ResponseEntity<ScheduleCreateResponse> createSchedule(
			@Validated @RequestBody ScheduleCreateRequest scheduleCreateRequest
	) {
		Long scheduleId = movieService.createSchedule(scheduleCreateRequest);
		return new ResponseEntity<>(new ScheduleCreateResponse(scheduleId), CREATED);
	}

	@GetMapping("/schedules")
	public ResponseEntity<ScheduleGetAllResponse> getAllSchedules() {
		return new ResponseEntity<>(new ScheduleGetAllResponse(movieService.getAllSchedules()), OK);
	}
}
