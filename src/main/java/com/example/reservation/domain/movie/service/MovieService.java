package com.example.reservation.domain.movie.service;

import static com.example.reservation.domain.movie.model.MovieMapper.*;
import static com.example.reservation.domain.movie.model.ScheduleMapper.*;
import static com.example.reservation.domain.theater.model.TheaterMapper.*;
import static java.util.stream.Collectors.*;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.reservation.domain.movie.model.ScheduleMapper;
import com.example.reservation.domain.movie.model.dto.MovieCreateRequest;
import com.example.reservation.domain.movie.model.dto.MovieDto;
import com.example.reservation.domain.movie.model.dto.ScheduleCreateRequest;
import com.example.reservation.domain.movie.model.dto.ScheduleDto;
import com.example.reservation.domain.movie.model.entity.Movie;
import com.example.reservation.domain.movie.model.entity.Schedule;
import com.example.reservation.domain.movie.repository.MovieRepository;
import com.example.reservation.domain.movie.repository.ScheduleRepository;
import com.example.reservation.domain.reservation.model.TicketCreateRequest;
import com.example.reservation.domain.reservation.service.TicketService;
import com.example.reservation.domain.theater.model.dto.TheaterDto;
import com.example.reservation.domain.theater.model.entity.Theater;
import com.example.reservation.domain.theater.service.TheaterService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {
	private final TicketService ticketService;
	private final TheaterService theaterService;

	private final MovieRepository movieRepository;
	private final ScheduleRepository scheduleRepository;

	@Transactional
	public Long createMovie(MovieCreateRequest movieCreateRequest) {
		Movie movie = movieRepository.save(toMovie(movieCreateRequest));
		return movie.getId();
	}

	@Transactional(readOnly = true)
	public MovieDto getMovie(Long movieId) {
		return toMovieDto(getMovieEntity(movieId));
	}

	@Transactional
	public Long createSchedule(ScheduleCreateRequest scheduleCreateRequest) {
		Movie movie = getMovieEntity(scheduleCreateRequest.getMovieId());
		TheaterDto theaterDto = theaterService.getTheater(scheduleCreateRequest.getTheaterId());
		Theater theater = toTheater(theaterDto);

		Schedule schedule = scheduleRepository.save(
				toSchedule(theater, movie, scheduleCreateRequest)
		);

		List<TicketCreateRequest> ticketCreateRequests = theater.getSeats()
				.stream()
				.map(seat -> new TicketCreateRequest(schedule, seat))
				.collect(toList());

		ticketService.createTickets(ticketCreateRequests);
		return schedule.getId();
	}

	@Transactional(readOnly = true)
	public List<ScheduleDto> getAllSchedules() {
		return scheduleRepository.findAll()
				.stream()
				.map(ScheduleMapper::toScheduleDto)
				.collect(toList());
	}

	private Movie getMovieEntity(Long movieId) {
		return movieRepository.findById(movieId)
				.orElseThrow(() -> new EntityNotFoundException("존재하지 않는 영화입니다."));
	}
}
