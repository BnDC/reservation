package com.example.reservation.domain.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation.domain.movie.model.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
