package com.example.reservation.domain.reservation.model.type;

import lombok.Getter;

@Getter
public enum TicketType {
	ADULT(0), CHILD(2000), SENIOR(5000), SPECIAL_ASSISTANCE(5000);

	private int discount;

	TicketType(int discount) {
		this.discount = discount;
	}
}
