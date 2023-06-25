package com.example.reservation.common.util;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.reservation.domain.member.model.CustomUserDetails;

public class AuthenticationUtil {
	public static String getUsername() {
		return getUserDetails().getUsername();
	}

	public static Long getLoginMemberId() {
		return getUserDetails().getMemberId();
	}

	public static Collection<? extends GrantedAuthority> getAuthorities() {
		return getUserDetails().getAuthorities();
	}

	private static CustomUserDetails getUserDetails() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication.getPrincipal().equals("anonymousUser")) {
			throw new IllegalArgumentException("인증되지 않은 객체입니다");
		}
		return (CustomUserDetails)authentication.getPrincipal();
	}
}
