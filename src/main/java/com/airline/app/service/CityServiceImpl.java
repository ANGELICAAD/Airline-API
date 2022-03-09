package com.airline.app.service;

import java.util.Iterator;
import java.util.List;

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
		List<City> list = cityRepository.findAll();
		System.out.println("lista " + list.size());
		for(City city:list) {
			System.out.println("city " + city.getName());
		}
//		String visa = cityRepository.visaRequired(name);
		City city = cityRepository.findByName(name);
		System.out.println("visa " + city.isVisa());
//		boolean requerid = (visa.equals("false")) ? false : true;
		
		return false;
	}
}
