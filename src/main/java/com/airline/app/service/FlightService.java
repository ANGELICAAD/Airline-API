package com.airline.app.service;

import java.util.Date;
import java.util.List;

import com.airline.app.dto.FlightDTO;
import com.airline.app.entity.Flight;

public interface FlightService {

	public List<FlightDTO> flightList(Date selectedDate, String originCity, String destinationCity, int numberPassanger);
	
	public Flight findFlight(int idFlight);
}
