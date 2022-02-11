package com.airline.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.airline.app.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

	// Listar las ciudades de origen
	@Query(value = "select distinct nombre from ciudad inner join ruta "
			+ "on ciudad.idCiudad = ruta.ciudadOrigen;", nativeQuery = true)
	List<String> listOriginCities();
	
	// Listar las ciudades destino de acuerdo a una ciudad origen
	@Query(value = "select cDestino.nombre from ciudad cOrigen inner join ruta r "
			+ "on cOrigen.idCiudad = r.ciudadOrigen inner join ciudad as cDestino "
			+ "on r.ciudadDestino = cDestino.idCiudad where cOrigen.nombre=:originCity", 
			nativeQuery = true)
	List<String> listDestinationCities(String originCity);
}
