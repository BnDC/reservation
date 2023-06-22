package com.example.reservation.domain.movie.model.entity;

import static javax.persistence.EnumType.*;
import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.reservation.domain.movie.model.type.AgeRating;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "movie")
@NoArgsConstructor(access = PROTECTED)
public class Movie {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Column(name = "title", length = 20)
	private String title;

	@Column(name = "director", length = 10)
	private String director;

	@Column(name = "original_price")
	private int originalPrice;

	@Column(name = "releaseDate")
	private LocalDate releaseDate;

	@Enumerated(value = STRING)
	private AgeRating ageRating;

	public Movie(
			String title, String director, int originalPrice,
			LocalDate releaseDate, AgeRating ageRating
	) {
		this.title = title;
		this.director = director;
		this.releaseDate = releaseDate;
		this.originalPrice = originalPrice;
		this.ageRating = ageRating;
	}

	@Override
	public String toString() {
		return "Movie{" +
				"id=" + id +
				", title='" + title + '\'' +
				", director='" + director + '\'' +
				", releaseDate=" + releaseDate +
				'}';
	}
}
