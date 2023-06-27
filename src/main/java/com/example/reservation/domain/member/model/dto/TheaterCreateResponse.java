package com.example.reservation.domain.member.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "극장 생성 응답")
@Getter
public class TheaterCreateResponse {
	@ApiModelProperty(value = "생성된 상영관 번호", example = "1")
	private Long theaterId;
	public TheaterCreateResponse(Long theaterId) {
		this.theaterId = theaterId;
	}
}
