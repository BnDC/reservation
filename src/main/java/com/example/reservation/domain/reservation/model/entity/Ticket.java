package com.example.reservation.domain.reservation.model.entity;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.example.reservation.domain.movie.model.entity.Schedule;
import com.example.reservation.domain.theater.model.entity.Seat;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "ticket")
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = PROTECTED)
public class Ticket {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@ManyToOne(optional = false, fetch = LAZY)
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;

	@OneToOne(optional = false, fetch = LAZY)
	@JoinColumn(name = "seat_id")
	private Seat seat;

	@Column(name = "is_reserved", nullable = false)
	private boolean isReserved;

	public Ticket(Long id, Schedule schedule, Seat seat) {
		this.id = id;
		this.schedule = schedule;
		this.seat = seat;
	}

	public Ticket(Schedule schedule, Seat seat) {
		this.schedule = schedule;
		this.seat = seat;
	}

	public void reserveTicket() {
		this.isReserved = true;
	}
}
