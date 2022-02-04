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
@Table(name = "tiquete")
@Inheritance(strategy = InheritanceType.JOINED)
public class Ticket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3456257342335893395L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTiquete")
	private Long idTicket;
	
	@Column(name = "totalPago")
	private String totalPayment;
	
	@ManyToOne
	@JoinColumn(name = "idReserva", referencedColumnName = "idReserva")
	private Reserve idReserve;
	
	@ManyToOne
	@JoinColumn(name = "idPasajero", referencedColumnName = "idPasajero")
	private Passenger idPassenger;

	public Long getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(Long idTicket) {
		this.idTicket = idTicket;
	}

	public String getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(String totalPayment) {
		this.totalPayment = totalPayment;
	}

	public Reserve getIdReserve() {
		return idReserve;
	}

	public void setIdReserve(Reserve idReserve) {
		this.idReserve = idReserve;
	}

	public Passenger getIdPassenger() {
		return idPassenger;
	}

	public void setIdPassenger(Passenger idPassenger) {
		this.idPassenger = idPassenger;
	}
}
