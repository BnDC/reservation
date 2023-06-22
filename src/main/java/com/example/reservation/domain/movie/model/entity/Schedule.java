package com.example.reservation.domain.movie.model.entity;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.reservation.domain.theater.model.entity.Theater;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedule")
@NoArgsConstructor(access = PROTECTED)
public class Schedule {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Column(name = "price")
	private int price;

	@Column(name = "start_time")
	private LocalDateTime startTime;

	@Column(name = "end_time")
	private LocalDateTime endTime;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "theater_id")
	private Theater theater;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "movie_id")
	private Movie movie;

	public Schedule(Theater theater, Movie movie, LocalDateTime startTime, LocalDateTime endTime) {
		this.theater = theater;
		this.movie = movie;
		this.price = calculatePrice();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Schedule{" +
				"id=" + id +
				", price=" + price +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", theater=" + theater +
				", movie=" + movie +
				'}';
	}

	private int calculatePrice() {
		return this.movie.getOriginalPrice() + this.theater.getTheaterType().getExtraCharge();
	}
}
