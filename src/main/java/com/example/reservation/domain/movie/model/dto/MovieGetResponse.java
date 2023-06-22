package com.example.reservation.domain.movie.model.dto;

import lombok.Getter;

@Getter
public class MovieGetResponse {
	private MovieDto movieDto;

	public MovieGetResponse(MovieDto movieDto) {
		this.movieDto = movieDto;
	}
}
