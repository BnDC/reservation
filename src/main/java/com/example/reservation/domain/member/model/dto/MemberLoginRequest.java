package com.example.reservation.domain.member.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;

@Getter
public class MemberLoginRequest {
	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String password;
}
