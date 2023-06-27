package com.example.reservation.domain.theater.model.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.example.reservation.domain.theater.model.type.TheaterType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "극장 생성 요청")
@Getter
public class TheaterCreateRequest {
	@ApiModelProperty(value = "상영관 이름", example = "hall-1", required = true)
	@NotBlank
	@Length(max = 10)
	private String name;

	@ApiModelProperty(value = "극장 타입", example = "NORMAL", required = true)
	@NotNull
	private TheaterType theaterType;

	@ApiModelProperty(value = "극장 이름", example = "강남", required = true)
	@NotBlank
	private String multiplexName;

	@ApiModelProperty(value = "극장 좌석 정보", example = "a1", required = true)
	@NotEmpty
	private List<String> seatPositions;
}
