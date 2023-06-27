package com.example.reservation.domain.member.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@ApiModel(description = "회원가입 요청 정보")
@Getter
@RequiredArgsConstructor
public class MemberSignupRequest {
	@ApiModelProperty(value = "이름", example = "홍길동")
	@NotBlank
	@Length(min = 5, max = 20)
	private final String name;

	@ApiModelProperty(value = "이메일", example = "test@email.com")
	@NotBlank
	@Length(min = 1, max = 20)
	@Email
	private final String email;

	@ApiModelProperty(value = "비밀번호", example = "test!1234")
	@NotBlank
	@Length(min = 8, max = 16)
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,16}$")
	private final String password;
}
