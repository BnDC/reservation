package com.example.reservation.domain.reservation.service;

import static com.example.reservation.domain.reservation.model.TicketMapper.*;
import static java.util.stream.Collectors.*;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.reservation.domain.reservation.model.Ticket;
import com.example.reservation.domain.reservation.model.TicketCreateRequest;
import com.example.reservation.domain.reservation.model.TicketDto;
import com.example.reservation.domain.reservation.model.TicketMapper;
import com.example.reservation.domain.reservation.repository.TicketRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketService {
	private final TicketRepository ticketRepository;

	@Transactional
	public void createTickets(List<TicketCreateRequest> ticketCreateRequests) {
		List<Ticket> tickets = ticketCreateRequests.stream()
				.map(ticketCreateRequest ->
						new Ticket(ticketCreateRequest.getSchedule(), ticketCreateRequest.getSeat()))
				.collect(toList());

		ticketRepository.saveAll(tickets);
	}

	@Transactional
	public List<TicketDto> getTickets() {
		return ticketRepository.findAll()
				.stream()
				.map(TicketMapper::toTicketDto)
				.collect(toList());
	}

	@Transactional
	public TicketDto updateTicket(Long ticketId) {
		Ticket ticket = ticketRepository.findById(ticketId)
				.orElseThrow(() -> new EntityNotFoundException("티켓이 존재하지 않습니다."));

		ticket.reserveTicket();
		return toTicketDto(ticket);
	}
}
