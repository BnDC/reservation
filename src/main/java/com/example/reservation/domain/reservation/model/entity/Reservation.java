package com.example.reservation.domain.reservation.model.entity;

import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "reservation")
@NoArgsConstructor(access = PROTECTED)
public class Reservation {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Column(name = "member_id")
	private Long memberId;

	@Column(name = "total_price")
	private int totalPrice = 0;

	@OneToMany(mappedBy = "reservation")
	private List<ReservationItem> reservationItems = new ArrayList<>();

	public Reservation(Long memberId) {
		this.memberId = memberId;
	}

	public void setReservationItems(List<ReservationItem> reservationItems) {
		this.reservationItems = reservationItems;
	}

	public void setTotalPrice() {
		if (this.reservationItems.isEmpty()) {
			throw new IllegalArgumentException("reservationItem이 없습니다");
		}
		this.totalPrice = reservationItems.stream()
				.map(ReservationItem::getPrice)
				.reduce(0, Integer::sum);
	}
}
