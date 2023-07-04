package com.example.reservation.common.util;

import java.util.Collection;

import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.reservation.domain.member.model.CustomUserDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
			log.debug("[AuthenticationUtil] can't get userDetails");
			throw new InsufficientAuthenticationException("It should have authenticated");
		}
		return (CustomUserDetails)authentication.getPrincipal();
	}
}
