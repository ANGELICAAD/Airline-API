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
@Table(name = "flight")
@Inheritance(strategy = InheritanceType.JOINED)
public class Flight implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1203881169669517458L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFlight")
	private Long idFlight;
	
	@Column(name = "number", nullable = false)
	private String number;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "date", nullable = false)
	@DateTimeFormat(pattern = "%Y-%m-%d")
	private Date date;
	
	@Column(name = "hour", nullable = false)
	private String hour;
	
	@Column(name = "duration", nullable = false)
	private String duration;
	
	@Column(name = "routeType", nullable = false)
	private String routeType;
	
	@Column(name = "chairsAvailable", nullable = false)
	private int chairsAvailable;
	
	@Column(name = "cost", nullable = false)
	private double cost;
	
	@ManyToOne
	@JoinColumn(name = "idRoute", referencedColumnName = "idRoute")
	private Route idRoute;

	public Long getIdFlight() {
		return idFlight;
	}

	public void setIdFlight(Long idFlight) {
		this.idFlight = idFlight;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
}
