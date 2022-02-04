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

@Entity
@Table(name = "pasajero")
@Inheritance(strategy = InheritanceType.JOINED)
public class Passenger implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8300582759646713983L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPasajero")
	private Long idPassenger;
	
	@Column(name = "documento")
	private String document;
	
	@Column(name = "nombre")
	private String name;
	
	@Column(name = "apellido")
	private String lastName;
	
	@Column(name = "telefono")
	private String phone;
	
	@Column(name = "correo")
	private String email;
	
	@Column(name = "edad")
	private int age;
	
	@Column(name = "tipoPasajero")
	private String passengerType;
	
	@Column(name = "fechaVencimientoVisa")
	private Date visaExpirationDate;
	
	@ManyToOne
	@JoinColumn(name = "idHistorial", referencedColumnName = "idHistorial")
	private Registry idRegistry;

	public Long getIdPassenger() {
		return idPassenger;
	}

	public void setIdPassenger(Long idPassenger) {
		this.idPassenger = idPassenger;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}

	public Date getVisaExpirationDate() {
		return visaExpirationDate;
	}

	public void setVisaExpirationDate(Date visaExpirationDate) {
		this.visaExpirationDate = visaExpirationDate;
	}

	public Registry getIdRegistry() {
		return idRegistry;
	}

	public void setIdRegistry(Registry idRegistry) {
		this.idRegistry = idRegistry;
	}
}
