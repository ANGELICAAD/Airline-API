package com.airline.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.app.entity.Passenger;
import com.airline.app.repository.PassengerRepository;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepository passengerRepository;

	/**
	 * Método para registrar un pasajero
	 */
	@Override
	public Passenger savePassenger(Passenger passenger) {
		return passengerRepository.save(passenger);
	}

	/**
	 * Método para buscar un pasajero por el id
	 */
	@Override
	public Passenger findPassenger(int idPassenger) {
		return passengerRepository.findById((long) idPassenger).get();
	}

	/**
	 * Método para verificar si un pasajero es frecuente
	 */
	@Override
	public String validateFrequentFlyer(int idPassenger, int miles) {
		Passenger passenger = findPassenger(idPassenger);
		int accumulateMiles = passenger.getNumberMiles() + miles;
		String message = messageStructure(passenger, accumulateMiles);		
		
		return message;
	}
	
	/**
	 * Método que estructura el mensaje de las millas a acumular de un pasajero frecuente
	 * 
	 * @param passenger Información del pasajero a validar
	 * @param accumulateMiles Millas que se van a acumular
	 * @return Mensaje informativo
	 */
	public String messageStructure(Passenger passenger, int accumulateMiles) {
		String message = "";
		
		if(passenger != null) {
			if(passenger.isFrequentFlyer() == true) {
				message += "Actualmente usted tiene " + passenger.getNumberMiles() +  " millas.";
				message += " Y se van a acumular " + accumulateMiles + " millas con el viaje.";
			}			
		}
		
		return message;
	}

	/**
	 *  Método para buscar un pasajero por documento
	 */
	@Override
	public Passenger findPassengerDocument(String document) {
		return passengerRepository.findPassengerDocument(document);
	}	
}
