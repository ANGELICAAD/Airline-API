package com.airline.app.dto;

import java.util.Date;

public class ReserveOWDTO {

	private String state;
	private String nameCityOriginDeparture;
	private String nameCityDestinationDeparture;
	private Date departureDate;
	private String departureRouteType;
	private String passengerName;
	private String passengerLastName;
	private String documentName;
	
	public ReserveOWDTO(String state, String nameCityOriginDeparture, String nameCityDestinationDeparture,
			Date departureDate, String departureRouteType, String passengerName, String passengerLastName,
			String documentName) {
		super();
		this.state = state;
		this.nameCityOriginDeparture = nameCityOriginDeparture;
		this.nameCityDestinationDeparture = nameCityDestinationDeparture;
		this.departureDate = departureDate;
		this.departureRouteType = departureRouteType;
		this.passengerName = passengerName;
		this.passengerLastName = passengerLastName;
		this.documentName = documentName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNameCityOriginDeparture() {
		return nameCityOriginDeparture;
	}

	public void setNameCityOriginDeparture(String nameCityOriginDeparture) {
		this.nameCityOriginDeparture = nameCityOriginDeparture;
	}

	public String getNameCityDestinationDeparture() {
		return nameCityDestinationDeparture;
	}

	public void setNameCityDestinationDeparture(String nameCityDestinationDeparture) {
		this.nameCityDestinationDeparture = nameCityDestinationDeparture;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureRouteType() {
		return departureRouteType;
	}

	public void setDepartureRouteType(String departureRouteType) {
		this.departureRouteType = departureRouteType;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerLastName() {
		return passengerLastName;
	}

	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
}
