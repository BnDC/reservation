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
import com.example.reservation.domain.theater.model.dto.TheaterGetResponse;
import com.example.reservation.domain.theater.model.dto.TheaterCreateRequest;
import com.example.reservation.domain.theater.model.dto.TheaterDto;
import com.example.reservation.domain.theater.service.TheaterService;

import lombok.RequiredArgsConstructor;

@RequestMapping("api/v1")
@RestController
@RequiredArgsConstructor
public class TheaterController {
	private final TheaterService theaterService;

	@PostMapping("/theaters/new")
	public ResponseEntity<TheaterCreateResponse> createTheater(
			@Validated @RequestBody TheaterCreateRequest theaterCreateRequest
	) {
		Long theaterId = theaterService.createTheater(theaterCreateRequest);
		return new ResponseEntity<>(new TheaterCreateResponse(theaterId), CREATED);
	}

	@GetMapping("/theaters/{theaterId}")
	public ResponseEntity<TheaterGetResponse> getTheater(@PathVariable Long theaterId) {
		TheaterDto theaterDto = theaterService.getTheater(theaterId);
		return new ResponseEntity<>(new TheaterGetResponse(theaterDto), OK);
	}
}
