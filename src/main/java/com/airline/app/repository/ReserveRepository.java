package com.airline.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.airline.app.entity.Reserve;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {

	@Query(value = "select state, origin, destination, fDeparture.date as dateDp, "
				+ "fDeparture.routeType as routeDateDp, fReturn.date as dateRt, "
				+ "fReturn.routeType as routeDateRt, passengerId, passengerName, "
				+ "passengerLastName, passengerDocument from reserve "
				+ "inner join flight as fDeparture on reserve.departureFlight=fDeparture.idFlight, "
				+ "(select origin, destination, flight.date, flight.routeType, flight.idFlight "
				+ "from flight, (select cOrigin.name as origin, cDestination.name as destination, "
				+ "r.idRoute from city as cOrigin inner join route r on cOrigin.idCity=r.originCity "
				+ "inner join city as cDestination on r.destinationCity=cDestination.idCity) as subR "
				+ "where flight.idRoute=subR.idRoute) as fReturn, "
				+ "(select passenger.idPassenger as passengerId, passenger.name as passengerName, "
				+ "passenger.lastName as passengerLastName, passenger.document as passengerDocument, "
				+ "ticket.idReserve from ticket inner join passenger "
				+ "on ticket.idPassenger=passenger.idPassenger) as subTi "
				+ "where reserve.returnFlight=fReturn.idFlight and reserve.idReserve=subTi.idReserve", 
				nativeQuery = true)
	List<Object[]> listReservationsCreated();
}
