package com.airline.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.airline.app.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

	@Query(value = "select distinct name from city inner join route "
			+ "on city.idCity = route.originCity;", nativeQuery = true)
	List<String> originCitiesList();
	
	@Query(value = "select cDestination.name from city as cOrigin inner join route r "
			+ "on cOrigin.idCity = r.originCity inner join city as cDestination "
			+ "on r.destinationCity = cDestination.idCity where cOrigin.name=:originCity", 
			nativeQuery = true)
	List<String> destinationCitiesList(String originCity);
	
	@Query(value = "select route.acumulateMiles from route inner join city as cOrigin "
			+ "on cOrigin.idCity=route.originCity inner join city cDestination "
			+ "on cDestination.idCity=route.destinationCity where cOrigin.name=:originCity "
			+ "and cDestination.name=:destinationCity", nativeQuery = true)
	int milesToAccumulate(String originCity, String destinationCity);
}
