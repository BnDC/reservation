package com.example.reservation.domain.movie.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "영화 사영 시간표 생성 응답")
@Getter
public class ScheduleCreateResponse {
	@ApiModelProperty(value = "영화 상영 시간표 식별자", example = "1")
	private Long scheduleId;

	public ScheduleCreateResponse(Long scheduleId) {
		this.scheduleId = scheduleId;
	}
}
