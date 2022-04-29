package com.airline.app.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.app.dto.FlightDTO;
import com.airline.app.entity.Flight;
import com.airline.app.jsonEntities.FlightList;
import com.airline.app.service.FlightService;

@RestController
@RequestMapping("/api/flight")
@CrossOrigin({"*"})
public class FlightController {

	@Autowired
	public FlightService flightService;
	
	@PostMapping("/")
	public ResponseEntity<?> flightList(@RequestBody FlightList info) throws ParseException {
		List<FlightDTO> flights = flightService.flightList(info.getSelectedDate(), info.getOriginCity(), info.getDestinationCity(), info.getNumberPassanger());

		if(flights.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(flights);
	}
	
	@GetMapping("/search/{idFlight}")
	public ResponseEntity<?> findFlight(@PathVariable int idFlight) {
		Flight flight = flightService.findFlight(idFlight);
		
		if(flight == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(flight);
	}
}
