package com.example.reservation.domain.member.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.example.reservation.domain.member.model.type.RoleName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "사업자 등록 요청")
@Getter
public class BusinessSignupRequest {
	@ApiModelProperty(value = "사업자 등록 번호", example = "0123456789", required = true)
	@NotBlank
	@Length(min = 10, max = 10)
	private String businessLicense;

	@ApiModelProperty(value = "사업자 종류", example = "THEATER_BUSINESS", required = true)
	@NotNull
	private RoleName roleName;
}
