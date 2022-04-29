package com.airline.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.airline.app.entity.Reserve;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {

	@Query(value = "select r.state, co.name as originCity, cd.name as destinationCity, f.date as departureDate, f.routeType as departureRoute, p.name as name, p.lastName as lastName, p.document as document "
			+ "from reserve as r inner join ticket as t on r.idReserve=t.idReserve "
			+ "inner join passenger as p on t.idPassenger=p.idPassenger "
			+ "inner join flight as f on r.departureFlight=f.idFlight "
			+ "inner join route as re on f.idRoute=re.idRoute " + "inner join city as co on re.originCity=co.idCity "
			+ "inner join city as cd on re.destinationCity=cd.idCity "
			+ "where r.idReserve=:idReserve", nativeQuery = true)
	List<Object[]> reservationsCreatedOW(int idReserve);

	@Query(value = "select r.state, cod.name as cityOriginDeparture, cdd.name as cityDestinationDeparture, fd.date as departureDate, fd.routeType as departureRoute, cor.name as cityOriginReturn, cdr.name as cityDestinationReturn, fr.date as ReturnDate, fr.routeType as returnRoute, p.name as name, p.lastName as lastName, p.document as document "
			+ "from reserve as r inner join ticket as t on r.idReserve=t.idReserve "
			+ "inner join passenger as p on t.idPassenger=p.idPassenger "
			+ "inner join flight as fd on r.departureFlight=fd.idFlight "
			+ "inner join route as red on fd.idRoute=red.idRoute "
			+ "inner join city as cod on red.originCity=cod.idCity "
			+ "inner join city as cdd on red.destinationCity=cdd.idCity "
			+ "inner join flight as fr on r.returnFlight=fr.idFlight "
			+ "inner join route as rer on fr.idRoute=rer.idRoute "
			+ "inner join city as cor on rer.originCity=cor.idCity "
			+ "inner join city as cdr on rer.destinationCity=cdr.idCity "
			+ "where r.idReserve=:idReserve", nativeQuery = true)
	List<Object[]> reservationsCreatedRT(int idReserve);
}
