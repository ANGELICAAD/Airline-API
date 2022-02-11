package com.airline.app.service;

import java.util.List;

public interface RouteService {

	// Listar las ciudades de origen
	public List<String> listOriginCities();
		
	// Listar las ciudades destino de acuerdo a una ciudad origen
	public List<String> listDestinationCities(String originCity);
}
