package com.example.reservation.domain.theater.controller;

import static org.springframework.http.HttpStatus.*;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservation.domain.member.model.dto.TheaterCreateResponse;
import com.example.reservation.domain.theater.model.dto.TheaterCreateRequest;
import com.example.reservation.domain.theater.model.dto.TheaterDto;
import com.example.reservation.domain.theater.model.dto.TheaterGetResponse;
import com.example.reservation.domain.theater.service.TheaterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@Api(tags = "극장 컨트롤러")
@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class TheaterController {
	private final TheaterService theaterService;

	@Operation(summary = "극장 생성", description = "극장 생성을 위한 api")
	@ApiResponse(code = 201, message = "created")
	@PostMapping("/theaters/new")
	public ResponseEntity<TheaterCreateResponse> createTheater(
			@Validated @RequestBody TheaterCreateRequest theaterCreateRequest
	) {
		Long theaterId = theaterService.createTheater(theaterCreateRequest);
		return new ResponseEntity<>(new TheaterCreateResponse(theaterId), CREATED);
	}

	@Operation(summary = "극장 조회", description = "극장 조회를 위한 api")
	@ApiResponse(code = 200, message = "ok")
	@GetMapping("/theaters/{theaterId}")
	public ResponseEntity<TheaterGetResponse> getTheater(
			@ApiParam(value = "상영관 식별자", required = true)
			@PathVariable
			Long theaterId
	) {
		TheaterDto theaterDto = theaterService.getTheater(theaterId);
		return new ResponseEntity<>(new TheaterGetResponse(theaterDto), OK);
	}
}
