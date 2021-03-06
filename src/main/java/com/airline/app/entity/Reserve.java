package com.airline.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reserve")
@Inheritance(strategy = InheritanceType.JOINED)
public class Reserve implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7611702281278307410L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idReserve")
	private Long idReserve;
	
	@Column(name = "state", nullable = false)
	private String state;
	
	@ManyToOne
	@JoinColumn(name = "departureFlight", referencedColumnName = "idFlight")
	private Flight departureFlight;
	
	@ManyToOne
	@JoinColumn(name = "returnFlight", referencedColumnName = "idFlight")
	private Flight returnFlight;
	
	@Column(name = "flightType")
	private String flightType;

	public Long getIdReserve() {
		return idReserve;
	}

	public void setIdReserve(Long idReserve) {
		this.idReserve = idReserve;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Flight getDepartureFlight() {
		return departureFlight;
	}

	public void setDepartureFlight(Flight departureFlight) {
		this.departureFlight = departureFlight;
	}

	public Flight getReturnFlight() {
		return returnFlight;
	}

	public void setReturnFlight(Flight returnFlight) {
		this.returnFlight = returnFlight;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}
}
