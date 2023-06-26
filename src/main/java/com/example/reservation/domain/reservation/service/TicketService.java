package com.example.reservation.domain.reservation.service;

import static com.example.reservation.domain.reservation.model.TicketMapper.*;
import static java.util.stream.Collectors.*;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.reservation.domain.reservation.model.entity.Ticket;
import com.example.reservation.domain.reservation.model.dto.TicketCreateRequest;
import com.example.reservation.domain.reservation.model.dto.TicketDto;
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
	public List<TicketDto> getTicketsWithLock(List<Long> ids) {
		List<TicketDto> ticketDtos = ticketRepository.findAllById(ids)
				.stream()
				.map(TicketMapper::toTicketDto)
				.collect(toList());

		for (TicketDto ticketDto : ticketDtos) {
			if (ticketDto.isReserved()) {
				throw new IllegalArgumentException("이미 예매된 티켓입니다.");
			}
		}
		return ticketDtos;
	}

	@Transactional
	public TicketDto updateTicket(Long ticketId) {
		Ticket ticket = ticketRepository.findById(ticketId)
				.orElseThrow(() -> new EntityNotFoundException("티켓이 존재하지 않습니다."));

		ticket.reserveTicket();
		return toTicketDto(ticket);
	}
}
