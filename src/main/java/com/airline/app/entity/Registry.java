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
@Table(name = "historial")
@Inheritance(strategy = InheritanceType.JOINED)
public class Registry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3266033074253307677L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idHistorial")
	private Long idRegistry;
	
	@Column(name = "cantidadViajes", nullable = true)
	private int numberTrips;
	
	@Column(name = "cantidadMillas", nullable = true)
	private int numberMiles;
	
	@ManyToOne
	@JoinColumn(name = "idPasajero", referencedColumnName = "idPasajero")
	private Passenger idPassenger;

	public Long getIdRegistry() {
		return idRegistry;
	}

	public void setIdRegistry(Long idRegistry) {
		this.idRegistry = idRegistry;
	}

	public int getNumberTrips() {
		return numberTrips;
	}

	public void setNumberTrips(int numberTrips) {
		this.numberTrips = numberTrips;
	}

	public int getNumberMiles() {
		return numberMiles;
	}

	public void setNumberMiles(int numberMiles) {
		this.numberMiles = numberMiles;
	}
}
