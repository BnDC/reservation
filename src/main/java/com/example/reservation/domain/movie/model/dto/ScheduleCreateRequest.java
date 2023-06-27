package com.example.reservation.domain.movie.model.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "영화 생성 요청")
@Getter
public class ScheduleCreateRequest {
	@ApiModelProperty(value = "영화 시작 시간", example = "2023-10-10 09:00:00", required = true)
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime startTime;

	@ApiModelProperty(value = "영화 종료 시간", example = "2023-10-10 11:00:00", required = true)
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime endTime;

	@ApiModelProperty(value = "극장 식별자", example = "1", required = true)
	@NotNull
	@Positive
	private Long theaterId;

	@ApiModelProperty(value = "영화 식별자", example = "1", required = true)
	@NotNull
	@Positive
	private Long movieId;
}
