package com.airline.app.service;

import java.util.Date;
import java.util.List;

import com.airline.app.entity.Flight;

public interface FlightService {

	public List<Object[]> flightList(Date selectedDate, String originCity, String destinationCity, int numberPassanger);
	
	public Flight findFlight(int idFlight);
}
