package com.airline.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "ciudad")
@Inheritance(strategy = InheritanceType.JOINED)
public class City implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5843555756240591040L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCiudad")
	private Long idCity;
	
	@Column(name = "nombre", nullable = false)
	private String name;
	
	@Column(name = "visa", nullable = false)
	private boolean visa;

	public Long getIdCity() {
		return idCity;
	}

	public void setIdCity(Long idCity) {
		this.idCity = idCity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisa() {
		return visa;
	}

	public void setVisa(boolean visa) {
		this.visa = visa;
	}
}
