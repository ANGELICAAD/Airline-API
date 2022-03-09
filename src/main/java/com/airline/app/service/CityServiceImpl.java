package com.airline.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.app.entity.City;
import com.airline.app.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;
	
	/**
	 * Método para verificar si una ciudad requiere visa
	 */
	@Override
	public boolean visaRequired(String name) {
		System.out.println("name " + name);
//		String visa = cityRepository.visaRequired(name);
		City city = cityRepository.findByName(name);
		System.out.println("visa " + city.isVisa());
//		boolean requerid = (visa.equals("false")) ? false : true;
		
		return false;
	}
}
