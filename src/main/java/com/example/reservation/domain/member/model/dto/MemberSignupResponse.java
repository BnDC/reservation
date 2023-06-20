package com.example.reservation.domain.member.model.dto;

import lombok.Getter;

@Getter
public class MemberSignupResponse {
	private Long memberId;

	public MemberSignupResponse(Long memberId) {
		this.memberId = memberId;
	}
}
