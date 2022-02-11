package com.airline.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.app.service.RouteService;

@RestController
@RequestMapping("/api/route")
@CrossOrigin({"*"})
public class RouteController {

	public RouteService routeService;

	public RouteController(RouteService routeService) {
		super();
		this.routeService = routeService;
	}
	
	@GetMapping("/originCities")
	public ResponseEntity<?> listOriginCities() {
		List<String> originCities = (List<String>) routeService.listOriginCities();
		
		if(originCities.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(originCities);
	}
	
	@GetMapping("/destinationCities/{originCity}")
	public ResponseEntity<?> listDestinationCities(@PathVariable String originCity) {
		List<String> destinationCities = (List<String>) routeService.listDestinationCities(originCity);
		
		if(destinationCities.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(destinationCities);
	}
}
