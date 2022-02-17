package com.airline.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.airline.app.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	// Consultar si la ciudad a la que se viaja necesita tener visa, por medio del nombre de la ciudad
	@Query(value = "select visa from city where city.name=:name", nativeQuery = true)
	String visaRequired(String name);
}
