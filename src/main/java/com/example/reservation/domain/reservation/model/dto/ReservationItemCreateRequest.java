package com.example.reservation.domain.reservation.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.example.reservation.domain.reservation.model.type.TicketType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

@ApiModel(description = "예매에 포함된 티켓 정보")
@Getter
@ToString
public class ReservationItemCreateRequest {
	@ApiModelProperty(value = "티켓 식별자", example = "1", required = true)
	@NotNull
	@Positive
	private Long ticketId;

	@ApiModelProperty(value = "티켓 타입", example = "ADULT", required = true)
	@NotNull
	private TicketType ticketType;
}
