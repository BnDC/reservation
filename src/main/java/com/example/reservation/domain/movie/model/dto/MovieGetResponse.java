package com.example.reservation.domain.movie.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "영화 단건 조회 결과")
@Getter
public class MovieGetResponse {

	@ApiModelProperty(value = "영화 정보")
	private MovieDto movieDto;

	public MovieGetResponse(MovieDto movieDto) {
		this.movieDto = movieDto;
	}
}
