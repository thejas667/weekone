package com.flightapp.flightbooking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flightapp.flightbooking.models.Airline;

public interface AirlineRepo extends JpaRepository<Airline, Long> {

	Airline findByAirlineName(String airlineName);

	@Modifying
	@Query("update Airline a set a.status = :status where a.airlineName = :airLineName")
	int updateByName(@Param("airLineName") String airLineName, @Param("status") String status);

}
