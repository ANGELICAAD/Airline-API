package com.airline.app.dto;

import java.util.Date;

public class ReserveRTDTO {

	private String state;
	private String nameCityOriginDeparture;
	private String nameCityDestinationDeparture;
	private Date departureDate;
	private String departureRouteType;
	private String nameCityOriginReturn;
	private String nameCityDestinationReturn;
	private Date returnDate;
	private String returnRouteType;
	private String passengerName;
	private String passengerLastName;
	private String documentName;
	
	public ReserveRTDTO(String state, String nameCityOriginDeparture, String nameCityDestinationDeparture,
			Date departureDate, String departureRouteType, String nameCityOriginReturn,
			String nameCityDestinationReturn, Date returnDate, String returnRouteType, String passengerName,
			String passengerLastName, String documentName) {
		super();
		this.state = state;
		this.nameCityOriginDeparture = nameCityOriginDeparture;
		this.nameCityDestinationDeparture = nameCityDestinationDeparture;
		this.departureDate = departureDate;
		this.departureRouteType = departureRouteType;
		this.nameCityOriginReturn = nameCityOriginReturn;
		this.nameCityDestinationReturn = nameCityDestinationReturn;
		this.returnDate = returnDate;
		this.returnRouteType = returnRouteType;
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

	public String getNameCityOriginReturn() {
		return nameCityOriginReturn;
	}

	public void setNameCityOriginReturn(String nameCityOriginReturn) {
		this.nameCityOriginReturn = nameCityOriginReturn;
	}

	public String getNameCityDestinationReturn() {
		return nameCityDestinationReturn;
	}

	public void setNameCityDestinationReturn(String nameCityDestinationReturn) {
		this.nameCityDestinationReturn = nameCityDestinationReturn;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getReturnRouteType() {
		return returnRouteType;
	}

	public void setReturnRouteType(String returnRouteType) {
		this.returnRouteType = returnRouteType;
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

	public void setDocumentrName(String documentName) {
		this.documentName = documentName;
	}
}
