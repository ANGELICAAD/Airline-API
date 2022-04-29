package com.airline.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.app.dto.ReserveOWDTO;
import com.airline.app.dto.ReserveRTDTO;
import com.airline.app.entity.Reserve;
import com.airline.app.repository.ReserveRepository;

@Service
public class ReserveServiceImpl implements ReserveService {

	@Autowired
	public ReserveRepository reserveRepository;

	/**
	 * Método para registrar una reserva
	 */
	@Override
	public Reserve saveReserve(Reserve reserve) {
		return reserveRepository.save(reserve);
	}

	/**
	 * Método para listar las reservas creadas de un vuelo de solo ida (OW)
	 */
	@Override
	public ReserveOWDTO reservationsCreatedOW(int idReserve) {
		List<Object[]> reserveOW = reserveRepository.reservationsCreatedOW(idReserve);
		List<ReserveOWDTO> reservesOWDTO = new ArrayList<>();

		String state = (String) reserveOW.get(0)[0];
		String nameCityOriginDeparture = (String) reserveOW.get(0)[1];
		String nameCityDestinationDeparture = (String) reserveOW.get(0)[2];
		Date departureDate = (Date) reserveOW.get(0)[3];
		String departureRouteType = (String) reserveOW.get(0)[4];
		String passengerName = (String) reserveOW.get(0)[5];
		String passengerLastName = (String) reserveOW.get(0)[6];
		String documentrName = (String) reserveOW.get(0)[7];

		ReserveOWDTO reserveRTDTO = new ReserveOWDTO(state, nameCityOriginDeparture, nameCityDestinationDeparture,
				departureDate, departureRouteType, passengerName, passengerLastName, documentrName);
		reservesOWDTO.add(reserveRTDTO);

		return reservesOWDTO.get(0);
	}

	/**
	 * Método para listar las reservas creadas de un vuelo de ida y regreso (RT)
	 */
	@Override
	public List<ReserveRTDTO> reservationsCreatedRT(int idReserve) {
		List<Object[]> reserveRT = reserveRepository.reservationsCreatedRT(idReserve);
		List<ReserveRTDTO> reservesRTDTO = new ArrayList<>();

		for (Object[] iterator : reserveRT) {
			String state = (String) iterator[0];
			String nameCityOriginDeparture = (String) iterator[1];
			String nameCityDestinationDeparture = (String) iterator[2];
			Date departureDate = (Date) iterator[3];
			String departureRouteType = (String) iterator[4];
			String nameCityOriginReturn = (String) iterator[5];
			String nameCityDestinationReturn = (String) iterator[6];
			Date returnDate = (Date) iterator[7];
			String returnRouteType = (String) iterator[8];
			String passengerName = (String) iterator[9];
			String passengerLastName = (String) iterator[10];
			String documentrName = (String) iterator[11];

			ReserveRTDTO reserveRTDTO = new ReserveRTDTO(state, nameCityOriginDeparture, nameCityDestinationDeparture,
					departureDate, departureRouteType, nameCityOriginReturn, nameCityDestinationReturn, returnDate,
					returnRouteType, passengerName, passengerLastName, documentrName);
			reservesRTDTO.add(reserveRTDTO);
		}

		return reservesRTDTO;
	}

	@Override
	public Reserve findReserve(int idReserve) {
		return reserveRepository.findById((long) idReserve).get();
	}
}
