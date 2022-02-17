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
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "passenger")
@Inheritance(strategy = InheritanceType.JOINED)
public class Passenger implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8300582759646713983L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPassenger")
	private Long idPassenger;
	
	@Column(name = "document", nullable = false)
	private String document;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	@Column(name = "phone", nullable = false)
	private String phone;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "age", nullable = false)
	private int age;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "visaExpirationDate", nullable = true)
	@DateTimeFormat(pattern = "%Y-%m-%d")
	private Date visaExpirationDate;
	
	@Column(name = "numberTrips", nullable = true)
	private int numberTrips;
	
	@Column(name = "numberMiles", nullable = true)
	private int numberMiles;
	
	@Column(name = "frequentFlyer", nullable = false)
	private boolean frequentFlyer;

	public Long getIdPassenger() {
		return idPassenger;
	}

	public void setIdPassenger(Long idPassenger) {
		this.idPassenger = idPassenger;
	}

	public String getDocument() {
		return document;
	}

//	public void setDocument(String document) {
//		this.document = document;
//	}

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

	public Date getVisaExpirationDate() {
		return visaExpirationDate;
	}

	public void setVisaExpirationDate(Date visaExpirationDate) {
		this.visaExpirationDate = visaExpirationDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public boolean isFrequentFlyer() {
		return frequentFlyer;
	}

	public void setFrequentFlyer(boolean frequentFlyer) {
		this.frequentFlyer = frequentFlyer;
	}
}
