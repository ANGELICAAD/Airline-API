package com.airline.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.airline.app.entity.Ticket;
import com.airline.app.service.TicketService;

@RestController
@RequestMapping("/api/ticket")
@CrossOrigin({"*"})
public class TicketController {

	@Autowired
	public TicketService ticketService;
	
	@GetMapping("/")
	public ResponseEntity<Integer> validateDiscounts(@RequestParam("idPassenger") int idPassenger) {
		int totalDiscount = ticketService.validateDiscounts(idPassenger);
		
		return ResponseEntity.ok(totalDiscount);
	}
	
	@PostMapping
	public ResponseEntity<?> saveTicket(@RequestBody Ticket ticket) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.saveTicket(ticket));
	}
	
	@GetMapping("/lastReservation/{idPassenger}")
	public ResponseEntity<?> lastReservation(@PathVariable int idPassenger) {
		int idReserve = ticketService.lastReservation(idPassenger);

		return ResponseEntity.ok(idReserve);
	}
	
	@GetMapping("/penultimateReservation/{idPassenger}")
	public ResponseEntity<?> penultimateReservation(@PathVariable int idPassenger) {
		int idReserve = ticketService.penultimateReservation(idPassenger);

		return ResponseEntity.ok(idReserve);
	}
}
