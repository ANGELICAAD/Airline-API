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
	public int[] validateFrequentFlyer(int idPassenger, int miles) {
		Passenger passenger = passengerRepository.findById((long) idPassenger).get();
		int accumulateMiles = passenger.getNumberMiles() + miles;
		int[] milesAccumulate = milesToAccumulate(passenger, accumulateMiles);		
		
		return milesAccumulate;
	}
	
	/**
	 * Método que retorna las millas que el pasajero tiene acumuladas y las que va a acumular
	 * con el viaje
	 * 
	 * @param passenger Información del pasajero a validar
	 * @param accumulateMiles Millas que se van a acumular
	 * @return Arreglo con las millas que tiene acumuladas y las que va a acumular
	 */
	public int[] milesToAccumulate(Passenger passenger, int accumulateMiles) {
		int[] miles = new int[2];
		
		if(passenger != null) {
			if(passenger.isFrequentFlyer() == true) {
				miles[0] = passenger.getNumberMiles();
				miles[1] = accumulateMiles;
			}			
		}
		
		return miles;
	}

	/**
	 *  Método para buscar un pasajero por documento
	 */
	@Override
	public Passenger findPassengerDocument(String document) {
		return passengerRepository.findPassengerDocument(document);
	}	
}
