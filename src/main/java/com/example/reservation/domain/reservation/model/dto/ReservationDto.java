package com.example.reservation.domain.reservation.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ReservationDto {
	private Long memberId;
	private int totalPrice;
	private List<ReservationItemDto> reservationItemDtos;

	public ReservationDto(Long memberId, int totalPrice, List<ReservationItemDto> reservationItemDtos) {
		this.memberId = memberId;
		this.totalPrice = totalPrice;
		this.reservationItemDtos = reservationItemDtos;
	}
}
