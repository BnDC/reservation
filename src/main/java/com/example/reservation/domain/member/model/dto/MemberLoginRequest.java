package com.example.reservation.domain.member.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "로그인 요청")
@Getter
public class MemberLoginRequest {
	@ApiModelProperty(value = "이메일", example = "test@email.com")
	@NotBlank
	@Email
	private String email;

	@ApiModelProperty(value = "비밀번호", example = "test!123456")
	@NotBlank
	private String password;
}
