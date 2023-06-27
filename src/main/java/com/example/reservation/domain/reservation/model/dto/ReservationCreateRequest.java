package com.example.reservation.domain.reservation.model.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@ApiModel(description = "예약 생성 요청")
public class ReservationCreateRequest {
	@ApiModelProperty(value = "예매에 포함된 티켓 정보", required = true)
	@NotEmpty
	List<ReservationItemCreateRequest> reservationItemCreateRequests;
}
