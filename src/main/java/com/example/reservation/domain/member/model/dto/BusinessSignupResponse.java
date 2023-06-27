package com.example.reservation.domain.member.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "사업자 요청 응답")
@Getter
public class BusinessSignupResponse {
	@ApiModelProperty(value = "사업자 정보 식별자", example = "1", required = true)
	private Long businessInformationId;

	public BusinessSignupResponse(Long businessInformationId) {
		this.businessInformationId = businessInformationId;
	}
}
