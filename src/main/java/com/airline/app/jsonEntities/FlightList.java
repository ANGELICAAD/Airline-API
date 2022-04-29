package com.airline.app.jsonEntities;

import java.util.Date;

public class FlightList {

	private Date selectedDate;
	private String originCity;
	private String destinationCity;
	private int numberPassanger;
	
	public FlightList(Date selectedDate, String originCity, String destinationCity, int numberPassanger) {
		super();
		this.selectedDate = selectedDate;
		this.originCity = originCity;
		this.destinationCity = destinationCity;
		this.numberPassanger = numberPassanger;
	}

	public Date getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}

	public String getOriginCity() {
		return originCity;
	}

	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public int getNumberPassanger() {
		return numberPassanger;
	}

	public void setNumberPassanger(int numberPassanger) {
		this.numberPassanger = numberPassanger;
	}
}
