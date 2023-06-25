package com.example.reservation.domain.movie.model;

import com.example.reservation.domain.movie.model.dto.MovieCreateRequest;
import com.example.reservation.domain.movie.model.dto.MovieDto;
import com.example.reservation.domain.movie.model.entity.Movie;

public class MovieMapper {
	public static Movie toMovie(MovieDto movieDto) {
		return new Movie(
				movieDto.getTitle(),
				movieDto.getDirector(),
				movieDto.getOriginalPrice(),
				movieDto.getReleaseDate(),
				movieDto.getAgeRating()
		);
	}

	public static Movie toMovie(MovieCreateRequest movieCreateRequest) {
		return new Movie(
				movieCreateRequest.getTitle(),
				movieCreateRequest.getDirector(),
				movieCreateRequest.getOriginalPrice(),
				movieCreateRequest.getReleaseDate(),
				movieCreateRequest.getAgeRating()
		);
	}

	public static MovieDto toMovieDto(Movie movie) {
		return new MovieDto(
				movie.getTitle(),
				movie.getDirector(),
				movie.getOriginalPrice(),
				movie.getReleaseDate(),
				movie.getAgeRating()
		);
	}
}
