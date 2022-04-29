package com.airline.app.service;

import java.util.List;

import com.airline.app.dto.ReserveOWDTO;
import com.airline.app.dto.ReserveRTDTO;
import com.airline.app.entity.Reserve;

public interface ReserveService {

	public Reserve saveReserve(Reserve reserve);

//	public Object reservationsCreatedOW(int idReserve);
	public ReserveOWDTO reservationsCreatedOW(int idReserve);

//	public Object[] reservationsCreatedRT(int idReserve);
	public List<ReserveRTDTO> reservationsCreatedRT(int idReserve);

	public Reserve findReserve(int idReserve);
}
