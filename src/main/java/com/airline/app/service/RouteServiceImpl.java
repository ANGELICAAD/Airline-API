package com.airline.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.app.repository.RouteRepository;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepository routeRepository;
	
	@Override
	public List<String> listOriginCities() {
		return routeRepository.listOriginCities();
	}

	@Override
	public List<String> listDestinationCities(String originCity) {
		return routeRepository.listDestinationCities(originCity);
	}

}
