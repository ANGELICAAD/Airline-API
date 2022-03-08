package com.airline.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	 * Método para listar las reservas creadas
	 */
	@Override
	public List<Object[]> listReservationsCreated() {
		return reserveRepository.listReservationsCreated();
	}

	@Override
	public Reserve findReserve(int idReserve) {
		return reserveRepository.findById((long) idReserve).get();
	}
}