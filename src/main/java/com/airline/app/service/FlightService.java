package com.airline.app.service;

import java.util.Date;
import java.util.List;

public interface FlightService {

	public List<Object[]> flightList(Date selectedDate, String originCity, String destinationCity, int numberPassanger);
}
