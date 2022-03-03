package com.airline.app.service;

import java.util.List;

import com.airline.app.entity.Reserve;

public interface ReserveService {

	public Reserve saveReserve(Reserve reserve);
	
	public List<Object[]> listReservationsCreated();
	
	public Reserve findReserve(int idReserve);
}
