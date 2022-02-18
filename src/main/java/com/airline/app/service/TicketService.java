package com.airline.app.service;

import java.util.Date;
import java.util.List;

import com.airline.app.entity.Ticket;

public interface TicketService {

	public int validateDiscounts(int idPassenger, Date departureDate, Date returnDate);
	
	public Ticket saveTicket(Ticket ticket);
}
