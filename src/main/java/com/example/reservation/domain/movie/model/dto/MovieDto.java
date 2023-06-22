package com.example.reservation.domain.movie.model.dto;

import java.time.LocalDate;

import com.example.reservation.domain.movie.model.type.AgeRating;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MovieDto {
	private String title;
	private String director;
	private int originalPrice;
	private LocalDate releaseDate;
	private AgeRating ageRating;

	public MovieDto(
			String title, String director, int originalPrice,
			LocalDate releaseDate, AgeRating ageRating
	) {
		this.title = title;
		this.director = director;
		this.originalPrice = originalPrice;
		this.releaseDate = releaseDate;
		this.ageRating = ageRating;
	}
}
