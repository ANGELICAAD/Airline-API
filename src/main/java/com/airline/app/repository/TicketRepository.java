package com.airline.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airline.app.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	// Cantidad de viajes que ha hecho un pasajero en un año o fecha específica
	int countFlights(int idPassenger, Date dateDeparture, Date dateReturn);
}
