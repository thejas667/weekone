package com.flightapp.flightbooking.repos;

import java.time.LocalTime;

import com.flightapp.flightbooking.models.FlightSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightScheduleRepo extends JpaRepository<FlightSchedule, Long>{

	FlightSchedule findByTakeOffAndToCity(LocalTime takeOff, Long toCity);

}
