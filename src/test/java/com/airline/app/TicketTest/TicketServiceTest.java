package com.airline.app.TicketTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.airline.app.entity.Passenger;
import com.airline.app.repository.PassengerRepository;
import com.airline.app.repository.TicketRepository;
import com.airline.app.service.TicketServiceImpl;

class TicketServiceTest {
	
	@InjectMocks
	private TicketServiceImpl ticketServiceImpl;
	
	private Passenger passenger, passenger2, passenger3;
	private int discount;

	@BeforeEach
	void setUp() throws Exception {
//		Se inicializa mockito
		MockitoAnnotations.initMocks(this);
		
		passenger = new Passenger();
		passenger.setIdPassenger((long) 3);
		passenger.setAge(20);
		passenger.setDocument("1095251264");
		passenger.setEmail("jmarin@gmail.com");
		passenger.setFrequentFlyer(true);
		passenger.setLastName("Marin");
		passenger.setName("Juan");
		passenger.setNumberMiles(100);
		passenger.setNumberTrips(20);
		passenger.setPhone("3105895751");
		passenger.setType("adulto");
		passenger.setVisaExpirationDate(null);
		
		passenger2 = new Passenger();
		passenger2.setIdPassenger((long) 3);
		passenger2.setAge(70);
		passenger2.setDocument("1095251264");
		passenger2.setEmail("jmarin@gmail.com");
		passenger2.setFrequentFlyer(true);
		passenger2.setLastName("Marin");
		passenger2.setName("Juan");
		passenger2.setNumberMiles(100);
		passenger2.setNumberTrips(20);
		passenger2.setPhone("3105895751");
		passenger2.setType("adulto");
		passenger2.setVisaExpirationDate(null);
		
		passenger3 = new Passenger();
		passenger3.setIdPassenger((long) 3);
		passenger3.setAge(1);
		passenger3.setDocument("1095251264");
		passenger3.setEmail("jmarin@gmail.com");
		passenger3.setFrequentFlyer(true);
		passenger3.setLastName("Marin");
		passenger3.setName("Juan");
		passenger3.setNumberMiles(10);
		passenger3.setNumberTrips(2);
		passenger3.setPhone("3105895751");
		passenger3.setType("infante");
		passenger3.setVisaExpirationDate(null);
	}

	/**
	 * Prueba que valida el descuento si un viajero es frecuente 
	 */
	@Test
	void validateFlightsFrequentFlyer() {
		discount = ticketServiceImpl.validateFlights(20, passenger);
		assertEquals(10, discount);
	}

	/**
	 * Prueba que valida el descuento si un viajero es normal 
	 */
	@Test
	void validateFlightsNormalFlyer() {
		discount = ticketServiceImpl.validateFlights(5, passenger);
		assertEquals(5, discount);
	}
	
	/**
	 * Prueba que valida el descuento de acuerdo a la edad de un viajero (edad normal) 
	 */
	@Test
	void validateAgeNoDiscount() {
		discount = ticketServiceImpl.validateAge(passenger);
		assertEquals(0, discount);
	}

	/**
	 * Prueba que valida el descuento de acuerdo a la edad de un viajero (edad mayor a 65) 
	 */
	@Test
	void validateAgeAdditionalDiscount() {
		discount = ticketServiceImpl.validateAge(passenger2);
		assertEquals(3, discount);
	}
	
	/**
	 * Prueba que valida el descuento de acuerdo a la edad de un viajero (edad menor a 2 e infante) 
	 */
	@Test
	void validateAgeNormalRateDiscount() {
		discount = ticketServiceImpl.validateAge(passenger3);
		assertEquals(10, discount);
	}
}
