package com.example.reservation.domain.member.model.type;

public enum RoleName {
	ADMIN, THEATER_BUSINESS, PERFORMANCE_BUSINESS, USER;

	public boolean isNotBusinessRole() {
		return !this.name().endsWith("BUSINESS");
	}
}
