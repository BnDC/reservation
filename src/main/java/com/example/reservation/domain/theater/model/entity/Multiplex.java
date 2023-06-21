package com.example.reservation.domain.theater.model.entity;

import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "multiplex")
@NoArgsConstructor(access = PROTECTED)
public class Multiplex {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Column(name = "name", unique = true, length = 10)
	private String name;

	@Column(name = "opening_day")
	private LocalDate openingDay;

	@Column(name = "start_time")
	private LocalTime startTime;

	@Column(name = "end_time")
	private LocalTime endTime;

	@Override
	public String toString() {
		return "Multiplex{" +
				"id=" + id +
				", name='" + name + '\'' +
				", openingDay=" + openingDay +
				", startTime=" + startTime +
				", endTime=" + endTime +
				'}';
	}
}
