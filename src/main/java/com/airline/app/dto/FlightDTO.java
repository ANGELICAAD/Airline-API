package com.airline.app.dto;

public class FlightDTO {

	private String hour;
	private String duration;
	private String routeType;
	private double cost;
	private int idFlight;
	
	public FlightDTO(String hour, String duration, String routeType, double cost, int idFlight) {
		super();
		this.hour = hour;
		this.duration = duration;
		this.routeType = routeType;
		this.cost = cost;
		this.idFlight = idFlight;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getRouteType() {
		return routeType;
	}

	public void setRouteType(String routeType) {
		this.routeType = routeType;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getIdFlight() {
		return idFlight;
	}

	public void setIdFlight(int idFlight) {
		this.idFlight = idFlight;
	}
}
