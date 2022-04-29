package com.airline.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.app.repository.RouteRepository;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepository routeRepository;
	
	/**
	 * Método para listar las ciudades origen
	 */
	@Override
	public List<String> originCitiesList() {
		return routeRepository.originCitiesList();
	}

	/**
	 * Método para listar las ciudades destino de acuerdo a un origen
	 */
	@Override
	public List<String> destinationCitiesList(String originCity) {
		return routeRepository.destinationCitiesList(originCity);
	}

	/**
	 * Método para buscar la cantidad de millas que se van a acumular con un viaje, de
	 * acuerdo a la ciudad de origen y destino
	 */
	@Override
	public int milesToAccumulate(String originCity, String destinationCity) {
		return routeRepository.milesToAccumulate(originCity, destinationCity);
	}
}
