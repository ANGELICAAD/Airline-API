package com.airline.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airline.app.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
