package com.example.reservation.domain.member.model;

import com.example.reservation.domain.member.model.dto.MemberSignupRequest;
import com.example.reservation.domain.member.model.entity.Member;

public class MemberMapper {

	public static Member toMember(MemberSignupRequest memberSignupRequest) {
		return new Member(
				memberSignupRequest.getName(),
				memberSignupRequest.getEmail(),
				memberSignupRequest.getPassword()
		);
	}

}
