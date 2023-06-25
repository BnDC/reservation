package com.example.reservation.domain.reservation.model;

import java.util.List;

import lombok.Getter;

@Getter
public class TicketsCreateRequest {
	List<TicketCreateRequest> ticketCreateRequestList;
}
