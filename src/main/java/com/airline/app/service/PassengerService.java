package com.airline.app.service;

import com.airline.app.entity.Passenger;

public interface PassengerService {

	public Passenger savePassenger(Passenger passenger);
	
	public Passenger findPassenger(int idPassenger);
	
	public Passenger findPassengerDocument(String document);
	
	public String validateFrequentFlyer(int idPassenger, int miles);
}
