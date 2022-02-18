package com.airline.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.airline.app.entity.Passenger;
import com.airline.app.entity.Ticket;
import com.airline.app.repository.PassengerRepository;
import com.airline.app.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	public TicketRepository ticketRepository;
	public PassengerRepository passengerRepository;
	
	public TicketServiceImpl(TicketRepository ticketRepository, PassengerRepository passengerRepository) {
		super();
		this.ticketRepository = ticketRepository;
		this.passengerRepository = passengerRepository;
	}

	@Override
//	public int validateDiscounts(int idPassenger, Date departureDate, Date returnDate) {
//		List<Integer> count = ticketRepository.countFlights(idPassenger, departureDate, returnDate);
//		int totalDiscount = 0;
//		int countFlights = 0;
//		System.out.println("entra " + passengerRepository.findById((long) idPassenger).get().getIdPassenger());
//		Passenger passenger = passengerRepository.findById((long) idPassenger).get();
//		System.out.println("!count.isEmpty() " + !count.isEmpty());
//		System.out.println("tamaño lista " + count.size());
//		System.out.println("tamaño lista " + count.get(0));
//		System.out.println("tamaño lista " + count.get(1));
//		if(!count.isEmpty()) {
//			System.out.println("entra a if");
//			countFlights = count.get(0) + count.get(1);
//			System.out.println("cantidad vuelos " + countFlights);
//			if(countFlights > 10 && passenger.isFrequentFlyer() == true) {
//				totalDiscount = 10;
//			} else {
//				totalDiscount = 5;
//				System.out.println("entra a porcentaje 5");
//			}
//		} 
//		if (passenger.getAge() > 65) {
//			totalDiscount += 3;
//		} else if (passenger.getAge() < 2 && passenger.getType().equals("infante")) {
//			totalDiscount += 10;
//		}
//		System.out.println("entra 2 " + totalDiscount);
//		return totalDiscount;
//	}
	public int validateDiscounts(int idPassenger, Date departureDate, Date returnDate) {
		int countDeparture = ticketRepository.countFlightsdeparture(idPassenger, departureDate, returnDate);
		int countReturn = ticketRepository.countFlightsReturn(idPassenger, departureDate, returnDate);
		int totalDiscount = 0;
		int countFlights = countDeparture + countReturn;
		Passenger passenger = passengerRepository.findById((long) idPassenger).get();

		
		if(countFlights > 10 && passenger.isFrequentFlyer() == true) {
			totalDiscount = 10;
		} else {
			totalDiscount = 5;
		}
		
		if (passenger.getAge() > 65) {
			totalDiscount += 3;
		} else if (passenger.getAge() < 2 && passenger.getType().equals("infante")) {
			totalDiscount += 10;
		}
		
		return totalDiscount;
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

}
