package com.example.reservation.domain.member.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberSignupRequest {

	@NotBlank
	@Length(min = 5, max = 20)
	private final String name;

	@NotBlank
	@Length(min = 1, max = 20)
	@Email
	private final String email;

	@NotBlank
	@Length(min = 8, max = 16)
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,16}$")
	private final String password;
}
