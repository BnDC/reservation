package com.example.reservation.domain.theater.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation.domain.theater.model.entity.Multiplex;

public interface MultiplexRepository extends JpaRepository<Multiplex, Long> {
	Optional<Multiplex> findMultiplexByName(String name);
}
