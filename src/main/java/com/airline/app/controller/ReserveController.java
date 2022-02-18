package com.airline.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.app.entity.Reserve;
import com.airline.app.service.ReserveService;

@RestController
@RequestMapping("/api/reserve")
@CrossOrigin({"*"})
public class ReserveController {

	@Autowired
	public ReserveService reserveService;

	@PostMapping
	public ResponseEntity<?> saveReserve(@RequestBody Reserve reserve) {
		return ResponseEntity.status(HttpStatus.CREATED).body(reserveService.saveReserve(reserve));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> listReservationsCreated() {
		List<Object[]> listReservations = reserveService.listReservationsCreated();
		
		if(listReservations.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(listReservations);
	}
}
