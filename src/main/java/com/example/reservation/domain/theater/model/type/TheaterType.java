package com.example.reservation.domain.theater.model.type;

public enum TheaterType {
	NORMAL(0), D3(3000), D4(4000);

	private final int extraCharge;

	TheaterType(int extraCharge) {
		this.extraCharge = extraCharge;
	}

	public int getExtraCharge() {
		return extraCharge;
	}
}
