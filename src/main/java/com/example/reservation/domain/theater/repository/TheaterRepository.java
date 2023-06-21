package com.example.reservation.domain.theater.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.reservation.domain.theater.model.entity.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
	@Query(value = "select t from Theater as t "
			+ "join fetch t.seats "
			+ "join fetch t.multiplex "
			+ "where t.id = :id")
	Optional<Theater> findTheaterByIdWithProperties(Long id);
}
