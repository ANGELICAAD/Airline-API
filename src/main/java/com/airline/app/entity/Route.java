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
@Table(name = "route")
@Inheritance(strategy = InheritanceType.JOINED)
public class Route implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -30646597920493571L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRoute")
	private Long idRoute;
	
	@Column(name = "acumulateMiles", nullable = false)
	private int acumulateMiles;
	
	@ManyToOne
	@JoinColumn(name = "originCity", referencedColumnName = "idCity")
	private City originCity;
	
	@ManyToOne
	@JoinColumn(name = "destinationCity", referencedColumnName = "idCity")
	private City destinationCity;

	public Long getIdRoute() {
		return idRoute;
	}

	public void setIdRoute(Long idRoute) {
		this.idRoute = idRoute;
	}

	public int getAcumulateMiles() {
		return acumulateMiles;
	}

	public void setAcumulateMiles(int acumulateMiles) {
		this.acumulateMiles = acumulateMiles;
	}
}
