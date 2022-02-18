package com.airline.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.app.entity.Passenger;
import com.airline.app.repository.PassengerRepository;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepository passengerRepository;
	
	@Override
	public Passenger savePassenger(Passenger passenger) {
		return passengerRepository.save(passenger);
	}

	@Override
	public Passenger findPassenger(int idPassenger) {
		return passengerRepository.findById((long) idPassenger).get();
	}

	@Override
	public String validateFrequentFlyer(int idPassenger, int miles) {
		Passenger passenger = findPassenger(idPassenger);
		String message = "";
		int accumulateMiles = passenger.getNumberMiles() + miles;
		
		if(passenger != null) {
			if(passenger.isFrequentFlyer() == true) {
				message += "Actualmente usted tiene " + passenger.getNumberMiles() +  " millas.";
				message += "\nY se van a acumular " + accumulateMiles + " millas con el viaje.";
			}			
		}
		
		return message;
	}	
}
