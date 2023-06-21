package com.example.reservation.domain.theater.model.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.example.reservation.domain.theater.model.type.TheaterType;

import lombok.Getter;

@Getter
public class TheaterCreateRequest {
	@NotBlank
	@Length(max = 10)
	private String name;
	@NotNull
	private TheaterType theaterType;
	@NotBlank
	private String multiplexName;
	@NotEmpty
	private List<String> seatPositions;
}
