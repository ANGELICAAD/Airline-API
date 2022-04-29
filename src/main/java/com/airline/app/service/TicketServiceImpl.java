package com.airline.app.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.airline.app.entity.Flight;
import com.airline.app.entity.Passenger;
import com.airline.app.entity.Reserve;
import com.airline.app.entity.Ticket;
import com.airline.app.repository.PassengerRepository;
import com.airline.app.repository.RouteRepository;
import com.airline.app.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	public TicketRepository ticketRepository;
	public PassengerRepository passengerRepository;
	public RouteRepository routeRepository;
	public final int DISCOUNT_FREQUENT_FLYER = 10;
	public final int DISCOUNT_NORMAL_FLYER = 5;
	public final int ADDITIONAL_DISCOUNT = 3;
	public final int NORMAL_RATE_DISCOUNT = 10;
//	DATOS REALES
//	public final Date DEPARTURE_DATE = new Date(2022,01,01);
//	public final Date RETURN_DATE = new Date(2022,03,01);
//	DATOS DE PRUEBA
	public final Date DEPARTURE_DATE = new Date(2021,11,10);
	public final Date RETURN_DATE = new Date(2021,11,21);

	public TicketServiceImpl(TicketRepository ticketRepository, PassengerRepository passengerRepository,
			RouteRepository routeRepository) {
		super();
		this.ticketRepository = ticketRepository;
		this.passengerRepository = passengerRepository;
		this.routeRepository = routeRepository;
	}

	/**
	 * Método para validad el descuento que tiene un pasajero por medio del id
	 */
	@Override
	public int validateDiscounts(int idPassenger) {
		int countDeparture = ticketRepository.countFlightsdeparture(idPassenger, DEPARTURE_DATE, RETURN_DATE);
		int countReturn = ticketRepository.countFlightsReturn(idPassenger, DEPARTURE_DATE, RETURN_DATE);
		int countFlights = countDeparture + countReturn;
		Passenger passenger = passengerRepository.findById((long) idPassenger).get();
		int totalDiscount = validateFlights(countFlights, passenger);
		totalDiscount += validateAge(passenger);

		return totalDiscount;
	}
	
	/**
	 * Método que permite validar el descuento si el pasajero es frecuente y ha viajado más de 10 veces
	 * 
	 * @param countFlights Cantidad de viajes que ha hecho un determinado pasajero
	 * @param passenger Información del pasajero a validar
	 * @return Total del descuento
	 */
	public int validateFlights(int countFlights, Passenger passenger) {
		int totalDiscount = 0;
		
		if (countFlights > 10 && passenger.isFrequentFlyer() == true) {
			totalDiscount = DISCOUNT_FREQUENT_FLYER;
		} else {
			totalDiscount = DISCOUNT_NORMAL_FLYER;
		}
		
		return totalDiscount;
	}

	/**
	 * Método que permite validar el descuento del pasajero de acuerdo a la edad
	 * 
	 * @param passenger Información del pasajero a validar
	 * @return Total del descuento
	 */
	public int validateAge(Passenger passenger) {
		int totalDiscount = 0;
		
		if (passenger.getAge() > 65) {
			totalDiscount += ADDITIONAL_DISCOUNT;
		} else if (passenger.getAge() < 2 && passenger.getType().equals("infante")) {
			totalDiscount += NORMAL_RATE_DISCOUNT;
		}
		
		return totalDiscount;
	}
	
	/**
	 * Método para registrar un tiquete
	 */
	@Override
	public Ticket saveTicket(Ticket ticket) {
		Reserve reserve = ticket.getIdReserve();
		Flight flightDeparture = reserve.getDepartureFlight();
		Flight flightReturn = reserve.getDepartureFlight();
		
		Passenger passenger = ticket.getIdPassenger();
		
		int accumulateMilesDeparture = flightDeparture.getIdRoute().getAcumulateMiles();
		int accumulateMilesReturn = flightReturn.getIdRoute().getAcumulateMiles();
		int totalAccumulateMiles = accumulateMilesDeparture + accumulateMilesReturn;
		
		if(reserve.getFlightType().equals("RT")) {
			flightDeparture.setChairsAvailable(flightDeparture.getChairsAvailable() - 1);
			flightReturn.setChairsAvailable(flightReturn.getChairsAvailable() - 1);
			
			passenger.setNumberTrips(passenger.getNumberTrips() + 2);
			passenger.setNumberMiles(passenger.getNumberMiles() + totalAccumulateMiles);
		} else {
			flightDeparture.setChairsAvailable(flightDeparture.getChairsAvailable() - 1);
			
			passenger.setNumberTrips(passenger.getNumberTrips() + 1);
			passenger.setNumberMiles(passenger.getNumberMiles() + accumulateMilesDeparture);
		}
		
		return ticketRepository.save(ticket);
	}

//	@Override
//	public int lastReservation(int idPassenger) {
//		return ticketRepository.lastReservation(idPassenger);
//	}
//
//	@Override
//	public int penultimateReservation(int idPassenger) {
//		return ticketRepository.penultimateReservation(idPassenger);
//	}
}
