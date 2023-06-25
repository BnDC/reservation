package com.example.reservation.domain.reservation.model;

import static javax.persistence.EnumType.*;
import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "reservation_item")
@NoArgsConstructor(access = PROTECTED)
public class ReservationItem {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@ManyToOne(optional = false, fetch = LAZY)
	@JoinColumn(name = "reservation_id")
	private Reservation reservation;

	@ManyToOne(optional = false, fetch = LAZY)
	@JoinColumn(name = "ticket_id")
	private Ticket ticket;

	@Enumerated(STRING)
	private TicketType ticketType;

	@Column(name = "price")
	private int price;

	public ReservationItem(Reservation reservation, Ticket ticket, TicketType ticketType) {
		this.reservation = reservation;
		this.ticket = ticket;
		this.ticketType = ticketType;
		this.price = calculate();
	}

	private int calculate() {
		return Math.max(0, ticket.getSchedule().getPrice() - this.ticketType.getDiscount());
	}
}
