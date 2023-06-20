package com.example.reservation.domain.member.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.example.reservation.domain.member.model.type.RoleName;

import lombok.Getter;

@Getter
public class BusinessSignupRequest {
	@NotBlank
	@Length(min = 10, max = 10)
	private String businessLicense;

	@NotNull
	private RoleName roleName;
}
