package com.airline.app.entity;

import java.io.Serializable;
import java.util.Date;

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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "vuelo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Flight implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1203881169669517458L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVuelo")
	private Long idFlight;
	
	@Column(name = "numeroVuelo", nullable = false)
	private String flightNumber;
	
	@Column(name = "tipoVuelo", nullable = false)
	private String flightType;
	
	@Column(name = "fecha", nullable = false)
	@DateTimeFormat(pattern = "%Y-%m-%d")
	private Date date;
	
	@Column(name = "hora")
	private String hour;
	
	@Column(name = "duracion")
	private String duration;
	
	@Column(name = "tipoRuta")
	private String routeType;
	
	@Column(name = "sillasDisponibles")
	private int chairsAvailable;
	
	@ManyToOne
	@JoinColumn(name = "idRuta", referencedColumnName = "idRuta")
	private Route idRoute;

	public Long getIdFlight() {
		return idFlight;
	}

	public void setIdFlight(Long idFlight) {
		this.idFlight = idFlight;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public int getChairsAvailable() {
		return chairsAvailable;
	}

	public void setChairsAvailable(int chairsAvailable) {
		this.chairsAvailable = chairsAvailable;
	}

	public Route getIdRoute() {
		return idRoute;
	}

	public void setIdRoute(Route idRoute) {
		this.idRoute = idRoute;
	}
}
