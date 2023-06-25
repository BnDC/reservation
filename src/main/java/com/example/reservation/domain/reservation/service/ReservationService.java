package com.example.reservation.domain.reservation.service;

import static com.example.reservation.domain.reservation.model.ReservationMapper.*;
import static com.example.reservation.domain.reservation.model.TicketMapper.*;
import static java.util.stream.Collectors.*;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.reservation.common.util.AuthenticationUtil;
import com.example.reservation.domain.reservation.model.Reservation;
import com.example.reservation.domain.reservation.model.ReservationCreateRequest;
import com.example.reservation.domain.reservation.model.ReservationDto;
import com.example.reservation.domain.reservation.model.ReservationItem;
import com.example.reservation.domain.reservation.repository.ReservationItemRepository;
import com.example.reservation.domain.reservation.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {

	private final TicketService ticketService;
	private final ReservationRepository reservationRepository;
	private final ReservationItemRepository reservationItemRepository;

	@Transactional
	public Long createReservation(ReservationCreateRequest reservationCreateRequest) {
		Reservation savedReservation = reservationRepository.save(new Reservation(AuthenticationUtil.getLoginMemberId()));

		List<ReservationItem> reservationItems =
				reservationCreateRequest.getReservationItemCreateRequests()
						.stream()
						.map(reservationItemCreateRequest ->
								new ReservationItem(
										savedReservation,
										toTicket(ticketService.updateTicket(reservationItemCreateRequest.getTicketId())),
										reservationItemCreateRequest.getTicketType()))
						.collect(toList());

		reservationItemRepository.saveAll(reservationItems);
		savedReservation.setReservationItems(reservationItems);
		savedReservation.setTotalPrice();

		return savedReservation.getId();
	}

	@Transactional
	public ReservationDto getReservation(Long reservationId) {
		Reservation reservation = reservationRepository.findReservationByIdWithReservationItems(reservationId)
				.orElseThrow(() -> new EntityNotFoundException("에약 없음"));
		return toReservationDto(reservation);
	}
}
