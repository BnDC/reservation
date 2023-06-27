package com.example.reservation.domain.movie.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "영화 생성 결과")
@Getter
public class MovieCreateResponse {

	@ApiModelProperty(value = "생성된 영화 식별자", example = "1")
	private Long movieId;

	public MovieCreateResponse(Long movieId) {
		this.movieId = movieId;
	}
}
