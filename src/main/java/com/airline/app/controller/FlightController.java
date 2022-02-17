package com.airline.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airline.app.service.FlightService;

@RestController
@RequestMapping("/api/flight")
@CrossOrigin({"*"})
public class FlightController {

	@Autowired
	public FlightService flightService;
	
	@GetMapping("/{originCity}&&{destinationCity}&&{numberPassanger}&&selectedDate")
	public ResponseEntity<?> flightList(@RequestParam("flightDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date selectedDate, 
										@PathVariable String originCity, @PathVariable String destinationCity, 
										@PathVariable int numberPassanger) {
		List<Object[]> flights = (List<Object[]>) flightService.flightList(selectedDate, originCity, destinationCity, numberPassanger);
		
		if(flights.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(flights);
	}
}
