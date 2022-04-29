package com.airline.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.airline.app.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	@Query(value = "select visa from city where city.name=:name", nativeQuery = true)
	String visaRequired(String name);
	
	// City findByName(String name);
}
