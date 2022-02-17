package com.airline.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.app.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepository;

	@Override
	public List<Object[]> flightList(Date selectedDate, String originCity, String destinationCity, int numberPassanger) {
		return flightRepository.flightList(selectedDate, originCity, destinationCity, numberPassanger);
	}
}
