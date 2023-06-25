package com.example.reservation.domain.reservation.model;

import static java.util.stream.Collectors.*;

public class ReservationMapper {
	public static ReservationDto toReservationDto(Reservation reservation) {
		return new ReservationDto(
				reservation.getMemberId(),
				reservation.getTotalPrice(),
				reservation.getReservationItems()
						.stream()
						.map(ReservationItemMapper::toReservationItemDto)
						.collect(toList())
		);
	}
}
