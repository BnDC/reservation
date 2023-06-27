package com.example.reservation.domain.movie.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import com.example.reservation.domain.movie.model.type.AgeRating;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public class MovieCreateRequest {
	@ApiModelProperty(value = "영화 제목", example = "타이타닉", required = true)
	@NotBlank
	@Length(max = 20)
	private String title;

	@ApiModelProperty(value = "영화 감독", example = "제임스 카메론", required = true)
	@NotBlank
	@Length(max = 10)
	private String director;

	@ApiModelProperty(value = "영화 정가", example = "10000", required = true)
	@NotNull
	@Positive
	private Integer originalPrice;

	@ApiModelProperty(value = "개봉일", example = "1997-12-19", required = true)
	@NotNull
	private LocalDate releaseDate;

	@ApiModelProperty(value = "영상물 등급", example = "ALL", required = true)
	@NotNull
	private AgeRating ageRating;
}
