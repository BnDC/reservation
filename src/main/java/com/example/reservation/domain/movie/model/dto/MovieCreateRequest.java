package com.example.reservation.domain.movie.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import com.example.reservation.domain.movie.model.type.AgeRating;

import lombok.Getter;

@Getter
public class MovieCreateRequest {
	@NotBlank
	@Length(max = 20)
	private String title;

	@NotBlank
	@Length(max = 10)
	private String director;

	@NotNull
	@Positive
	private Integer originalPrice;

	@NotNull
	private LocalDate releaseDate;

	@NotNull
	private AgeRating ageRating;
}
