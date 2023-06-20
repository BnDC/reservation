package com.example.reservation.common.util;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticationUtil {
	public static String getUsername() {
		return getUserDetails().getUsername();
	}

	public static Collection<? extends GrantedAuthority> getAuthorities() {
		return getUserDetails().getAuthorities();
	}

	private static UserDetails getUserDetails() {
		return (UserDetails)SecurityContextHolder.getContext()
				.getAuthentication()
				.getPrincipal();
	}
}
