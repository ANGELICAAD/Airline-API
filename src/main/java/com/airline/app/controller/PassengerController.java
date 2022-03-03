package com.airline.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airline.app.entity.Passenger;
import com.airline.app.service.PassengerService;

@RestController
@RequestMapping("/api/passenger")
@CrossOrigin({"*"})
public class PassengerController {

	@Autowired
	public PassengerService passengerService;

	public PassengerController(PassengerService passengerService) {
		super();
		this.passengerService = passengerService;
	}

	@PostMapping
	public ResponseEntity<?> savePassenger(@RequestBody Passenger passenger) {
		return ResponseEntity.status(HttpStatus.CREATED).body(passengerService.savePassenger(passenger));
	}
	
	@GetMapping("/validate/{idPassenger}&&{miles}")
	public ResponseEntity<?> validateFrequentFlyer(@PathVariable String idPassenger, @PathVariable String miles) {
		String message = passengerService.validateFrequentFlyer(Integer.parseInt(idPassenger), Integer.parseInt(miles));
		
		if(message.equals("")) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(Map.of("ms", message));
	}
	
	@GetMapping("/{idPassenger}")
	public ResponseEntity<?> findPassenger(@PathVariable int idPassenger) {
		Passenger passenger = passengerService.findPassenger(idPassenger);
		
		if(passenger == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(passenger);
	}
	
	@GetMapping("/search/{document}")
	public ResponseEntity<?> findPassengerDocument(@PathVariable String document) {
		Passenger passenger = passengerService.findPassengerDocument(document);
		
		if(passenger == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(passenger);
	}
}
