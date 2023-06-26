package com.example.reservation.domain.reservation.model.dto;

import java.util.List;

import com.example.reservation.domain.reservation.model.dto.TicketCreateRequest;

import lombok.Getter;

@Getter
public class TicketsCreateRequest {
	List<TicketCreateRequest> ticketCreateRequestList;
}
