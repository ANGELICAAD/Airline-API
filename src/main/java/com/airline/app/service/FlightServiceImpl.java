package com.airline.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.app.dto.FlightDTO;
import com.airline.app.entity.Flight;
import com.airline.app.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepository;

	/**
	 * Método para listar todos los vuelos
	 */
	@Override
	public List<FlightDTO> flightList(Date selectedDate, String originCity, String destinationCity, int numberPassanger) {
		List<Object[]> flights = flightRepository.flightList(selectedDate, originCity, destinationCity, numberPassanger);
		List<FlightDTO> flightsDTO = new ArrayList<>();
		
		for (Object[] iterator : flights) {
			
			String hour = (String) iterator[0];
			String duration = (String) iterator[1];
			String routeType = (String) iterator[2];
			double cost = (double) iterator[3];
			int idFlight = Integer.parseInt(iterator[4] + "");
			
			FlightDTO dto = new FlightDTO(hour, duration, routeType, cost, idFlight);
			flightsDTO.add(dto);
		}		
		
		return flightsDTO;
	}

	/**
	 * Método para buscar un vuelo especifico
	 */
	@Override
	public Flight findFlight(int idFlight) {
		return flightRepository.findById((long) idFlight).get();
	}
}
