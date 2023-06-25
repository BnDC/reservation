package com.example.reservation.domain.theater.service;

import static com.example.reservation.domain.theater.model.TheaterMapper.*;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.reservation.domain.theater.model.dto.TheaterCreateRequest;
import com.example.reservation.domain.theater.model.dto.TheaterDto;
import com.example.reservation.domain.theater.model.entity.Multiplex;
import com.example.reservation.domain.theater.model.entity.Seat;
import com.example.reservation.domain.theater.model.entity.Theater;
import com.example.reservation.domain.theater.repository.MultiplexRepository;
import com.example.reservation.domain.theater.repository.SeatRepository;
import com.example.reservation.domain.theater.repository.TheaterRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TheaterService {
	private final MultiplexRepository multiplexRepository;
	private final TheaterRepository theaterRepository;
	private final SeatRepository seatRepository;

	@Transactional
	public Long createTheater(TheaterCreateRequest theaterCreateRequest) {
		Multiplex multiplex = multiplexRepository.findMultiplexByName(theaterCreateRequest.getMultiplexName())
				.orElseThrow(() -> new EntityNotFoundException("영화관이 존재 하지 않습니다."));

		Theater theater = theaterRepository.save(toTheaterNoSeats(theaterCreateRequest, multiplex));
		List<Seat> seats = theaterCreateRequest.getSeatPositions()
				.stream()
				.map(seatPosition -> new Seat(seatPosition, theater))
				.collect(Collectors.toList());

		seatRepository.saveAll(seats);
		return theater.getId();
	}

	@Transactional
	public TheaterDto getTheater(Long theaterId) {
		Theater theater = theaterRepository.findTheaterByIdWithProperties(theaterId)
				.orElseThrow(() -> new EntityNotFoundException("존재하지 않는 영화관입니다"));

		// TODO removed
		log.info("theater = {}", theater);

		return toTheaterDto(theater);
	}
}
