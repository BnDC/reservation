package com.example.reservation.domain.member.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "영화 회원가입 응답")
@Getter
public class MemberSignupResponse {
	@ApiModelProperty(value = "영화정보 식별자", example = "1", required = true)
	private Long memberId;

	public MemberSignupResponse(Long memberId) {
		this.memberId = memberId;
	}
}
