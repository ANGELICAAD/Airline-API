package com.airline.app.service;

import java.util.List;

public interface RouteService {

	public List<String> originCitiesList();
		
	public List<String> destinationCitiesList(String originCity);
	
	public int milesToAccumulate(String originCity, String destinationCity);
}
