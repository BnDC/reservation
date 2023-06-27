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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Api(tags = "영화 컨트롤러")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MovieController {
	private final MovieService movieService;

	@Operation(summary = "영화 정보 생성", description = "영화 정보 생성을 위한 api")
	@ApiResponse(code = 201, message = "created")
	@PostMapping("/movies/new")
	public ResponseEntity<MovieCreateResponse> createMovie(
			@Validated @RequestBody MovieCreateRequest movieCreateRequest
	) {
		Long movieId = movieService.createMovie(movieCreateRequest);
		return new ResponseEntity<>(new MovieCreateResponse(movieId), CREATED);
	}

	@Operation(summary = "영화 정보 단건 조회", description = "영화 정보 단건 조회를 위한 api")
	@ApiResponse(code = 200, message = "ok")
	@GetMapping("/movies/{movieId}")
	public ResponseEntity<MovieGetResponse> getMovie(
			@ApiParam(value = "영화 정보 식별자", example = "1", required = true) @PathVariable Long movieId) {
		MovieDto movie = movieService.getMovie(movieId);
		return new ResponseEntity<>(new MovieGetResponse(movie), OK);
	}

	@Operation(summary = "영화 상영 시간표 생성", description = "영화 상영 시간표 생성을 위한 api")
	@ApiResponse(code = 201, message = "created")
	@PostMapping("/schedules/new")
	public ResponseEntity<ScheduleCreateResponse> createSchedule(
			@Validated @RequestBody ScheduleCreateRequest scheduleCreateRequest
	) {
		Long scheduleId = movieService.createSchedule(scheduleCreateRequest);
		return new ResponseEntity<>(new ScheduleCreateResponse(scheduleId), CREATED);
	}

	@Operation(summary = "영화 상영 시간표 조회", description = "영화 상영 시간표 조회를 위한 api")
	@ApiResponse(code = 200, message = "ok")
	@GetMapping("/schedules")
	public ResponseEntity<ScheduleGetAllResponse> getAllSchedules() {
		return new ResponseEntity<>(new ScheduleGetAllResponse(movieService.getAllSchedules()), OK);
	}
}
