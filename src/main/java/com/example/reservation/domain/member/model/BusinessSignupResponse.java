package com.example.reservation.domain.member.model;

import lombok.Getter;

@Getter
public class BusinessSignupResponse {
	private Long businessInformationId;

	public BusinessSignupResponse(Long businessInformationId) {
		this.businessInformationId = businessInformationId;
	}
}
