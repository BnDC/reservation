package com.example.reservation.domain.member.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

	private final Long memberId;

	private final UserDetails userDetails;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return userDetails.getAuthorities();
	}

	@Override
	public String getPassword() {
		return userDetails.getPassword();
	}

	@Override
	public String getUsername() {
		return userDetails.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		return userDetails.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return userDetails.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return userDetails.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return userDetails.isEnabled();
	}

	@Override
	public String toString() {
		return "CustomUserDetails" + "{" + "memberId= " + memberId + " " + userDetails.toString();
	}

	public Long getMemberId() {
		return memberId;
	}
}
