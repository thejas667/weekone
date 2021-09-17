package com.example.jpa;

import com.example.dbdata.FlightSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;

@Repository
public interface FlightScheduleRepo extends JpaRepository<FlightSchedule, Long> {

    FlightSchedule findByTakeOffAndToCity(LocalTime takeOff, Long toCity);

}
