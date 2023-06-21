package com.example.reservation.domain.theater.model.entity;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "seat")
@NoArgsConstructor(access = PROTECTED)
public class Seat {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Column(name = "position", unique = true)
	private String position;

	@ManyToOne(optional = false, fetch = LAZY)
	@JoinColumn(name = "theater_id")
	private Theater theater;

	public Seat(String position, Theater theater) {
		this.position = position;
		this.theater = theater;
	}

	@Override
	public String toString() {
		return "Seat{" +
				"id=" + id +
				", position='" + position + '\'' +
				", theater=" + "{ " + "id" + theater.getId() + "name" + theater.getName() + " }" +
				'}';
	}
}
