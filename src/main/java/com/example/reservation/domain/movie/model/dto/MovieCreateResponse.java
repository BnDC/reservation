package com.example.reservation.domain.movie.model.dto;

import lombok.Getter;

@Getter
public class MovieCreateResponse {
	private Long movieId;

	public MovieCreateResponse(Long movieId) {
		this.movieId = movieId;
	}
}
