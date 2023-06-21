package com.example.reservation.domain.theater.model.entity;

import static javax.persistence.EnumType.*;
import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.reservation.domain.theater.model.type.TheaterType;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "theater")
@NoArgsConstructor(access = PROTECTED)
public class Theater {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Column(name = "name", length = 10)
	private String name;

	@Enumerated(STRING)
	private TheaterType theaterType;

	@ManyToOne(optional = false, fetch = LAZY)
	@JoinColumn(name = "multiplex_id")
	private Multiplex multiplex;

	@OneToMany(mappedBy = "theater")
	private List<Seat> seats = new ArrayList<>();

	public Theater(String name, TheaterType theaterType, Multiplex multiplex) {
		this.name = name;
		this.theaterType = theaterType;
		this.multiplex = multiplex;
	}

	@Override
	public String toString() {
		return "Theater{" +
				"id=" + id +
				", name='" + name + '\'' +
				", theaterType=" + theaterType +
				", multiplex=" + multiplex +
				", seats=" + seats +
				'}';
	}
}
