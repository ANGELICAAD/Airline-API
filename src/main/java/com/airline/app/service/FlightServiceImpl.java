package com.airline.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Object[]> flightList(Date selectedDate, String originCity, String destinationCity, int numberPassanger) {
		return flightRepository.flightList(selectedDate, originCity, destinationCity, numberPassanger);
	}

	/**
	 * Método para buscar un vuelo especifico
	 */
	@Override
	public Flight findFlight(int idFlight) {
		return flightRepository.findById((long) idFlight).get();
	}
}
