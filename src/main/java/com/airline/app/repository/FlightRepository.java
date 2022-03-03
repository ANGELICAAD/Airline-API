package com.airline.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.airline.app.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

	// Listar vuelos de acuerdo a la ciudad de origen, ciudad destino, la fecha y la cantidad de pasajeros
	@Query(value = "select hour, duration, routeType, cost, idFlight from flight, "
				+ "(select route.idRoute from route inner join city as cOrigin "
				+ "on route.originCity=cOrigin.idCity inner join city as cDestination "
				+ "on route.destinationCity=cDestination.idCity "
				+ "where cOrigin.name=:originCity "
				+ "and cDestination.name=:destinationCity) as subRoute "
				+ "where flight.idRoute=subRoute.idRoute "
				+ "and flight.date=DATE_FORMAT(:selectedDate,\"%Y-%m-%d\") "
				+ "and flight.chairsAvailable>:numberPassanger", 
				nativeQuery = true)
	List<Object[]> flightList(Date selectedDate, String originCity, String destinationCity, int numberPassanger);
}
