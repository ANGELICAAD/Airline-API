package com.airline.app.service;

import java.util.Date;
import java.util.List;

import com.airline.app.entity.Ticket;

public interface TicketService {

	public int validateDiscounts(int idPassenger);
	
	public Ticket saveTicket(Ticket ticket);
	
	public int lastReservation(int idPassenger);
	
	public int penultimateReservation(int idPassenger);
}
