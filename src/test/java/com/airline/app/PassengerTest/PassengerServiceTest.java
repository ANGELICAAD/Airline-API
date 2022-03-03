package com.airline.app.PassengerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.airline.app.controller.PassengerController;
import com.airline.app.entity.Passenger;
import com.airline.app.repository.PassengerRepository;
import com.airline.app.service.PassengerService;
import com.airline.app.service.PassengerServiceImpl;

class PassengerServiceTest {
	
//	Se crean los enlaces con el servicio que se está trabajando
	
	@InjectMocks
	private PassengerServiceImpl passengerServiceImpl;

	private Passenger passenger;
	private String message;
	
	@BeforeEach
	void setUp() {
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
	}
	
	/**
	 * Prueba el mensaje de respuesta para informas las millas acumuladas y las que se van a acumular 
	 */
	@Test
	void messageStructure() {
		message = passengerServiceImpl.messageStructure(passenger, 20);
		String expect = "Actualmente usted tiene 100 millas. Y se van a acumular 20 millas con el viaje.";
		assertEquals(expect, message);
	}
}
