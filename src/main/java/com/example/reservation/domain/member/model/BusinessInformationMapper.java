package com.example.reservation.domain.member.model;

import com.example.reservation.domain.member.model.dto.BusinessSignupRequest;
import com.example.reservation.domain.member.model.entity.BusinessInformation;
import com.example.reservation.domain.member.model.entity.Member;

public class BusinessInformationMapper {
	public static BusinessInformation toBusinessInformation(
			BusinessSignupRequest businessSignupRequest, Member member
	) {
		return new BusinessInformation(
				businessSignupRequest.getBusinessLicense(),
				member
		);
	}
}
