package com.airline.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.airline.app.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query(value = "select count(subReserve.departureFlight) from ticket, "
			+ "(select * from reserve inner join flight "
			+ "on reserve.departureFlight=flight.idFlight "
			+ "where flight.date between DATE_FORMAT(:departureDate,\"%Y-%m-%d\") "
			+ "and DATE_FORMAT(:returnDate,\"%Y-%m-%d\")) as subReserve "
			+ "where ticket.idReserve=subReserve.idReserve "
			+ "and ticket.idPassenger=:idPassenger", nativeQuery = true)
	int countFlightsdeparture(int idPassenger, Date departureDate, Date returnDate);
	
	@Query(value = "select count(subReserve.returnFlight) from ticket, "
			+ "(select * from reserve inner join flight "
			+ "on reserve.departureFlight=flight.idFlight "
			+ "where flight.date between DATE_FORMAT(:departureDate,\"%Y-%m-%d\") "
			+ "and DATE_FORMAT(:returnDate,\"%Y-%m-%d\")) as subReserve "
			+ "where ticket.idReserve=subReserve.idReserve "
			+ "and ticket.idPassenger=:idPassenger", nativeQuery = true)
	int countFlightsReturn(int idPassenger, Date departureDate, Date returnDate);
	
//	@Query(value = "select max(idReserve) from ticket where idPassenger=:idPassenger", nativeQuery = true)
//	int lastReservation(int idPassenger);
//	
//	@Query(value = "select max(idReserve)-1 from ticket where idPassenger=:idPassenger", nativeQuery = true)
//	int penultimateReservation(int idPassenger);
}
