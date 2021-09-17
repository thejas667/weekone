package com.flightapp.flightbooking.repos;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightapp.flightbooking.models.BookFlightTicket;

@Repository
public interface BookiFlightRepo extends JpaRepository<BookFlightTicket, Long> {

	@Query("select sum(b.totTickets) from BookFlightTicket b where b.flightId = :flightId and b.dateOfJourney = :dateOfJourney and b.bookingClass = :bookingClass")
	int findByFlightIdAndDateOfJourneyAndBookingClass(@Param("flightId") Long flightId,@Param("dateOfJourney")  LocalDate dateOfJourney,@Param("bookingClass")String bookingClass);

}
