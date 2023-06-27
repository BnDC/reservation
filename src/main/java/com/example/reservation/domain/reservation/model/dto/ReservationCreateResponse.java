package com.example.reservation.domain.reservation.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "예매 등록 응답")
@Getter
public class ReservationCreateResponse {
	@ApiModelProperty(value = "예매 식별자", example = "1")
	private Long ReservationId;

	public ReservationCreateResponse(Long reservationId) {
		ReservationId = reservationId;
	}
}
