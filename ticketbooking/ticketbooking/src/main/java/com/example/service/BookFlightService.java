package com.example.service;

import com.example.dbdata.BookFlightTicket;
import com.example.dbdata.PassangerDtl;
import com.example.dtos.BookFlightDto;
import com.example.jpa.BookiFlightRepo;
import com.example.jpa.FlightScheduleRepo;
import com.example.jpa.PassangerDtlRepo;
import com.example.mapper.FlightBookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookFlightService {
    @Autowired
    private BookiFlightRepo bookiFlightRepo;

    @Autowired
    private PassangerDtlRepo passangerDtlRepo;

    @Autowired
    private FlightBookingMapper flightBookingMapper;

    @Autowired
    private FlightScheduleRepo flightScheduleRepo;

    public ResponseEntity<String> saveBooking(BookFlightDto bookFlightDto) {
        BookFlightTicket flightTicket = flightBookingMapper.map(bookFlightDto, BookFlightTicket.class);
        Set<PassangerDtl> passangers = flightTicket.getPassangerDlt().stream().collect(Collectors.toSet());
        flightTicket.getPassangerDlt().clear();
        Long selFlight = null;
        if(flightTicket.getBookingClass() == "1C") {
            selFlight = flightScheduleRepo.findById(flightTicket.getFlightId()).get().getFirstClassSeats();
        }
        else if(flightTicket.getBookingClass() == "2C") {
            selFlight = flightScheduleRepo.findById(flightTicket.getFlightId()).get().getSecondClassSeats();
        }
        else if(flightTicket.getBookingClass() == "3C") {
            selFlight = flightScheduleRepo.findById(flightTicket.getFlightId()).get().getThirdClassSeats();
        }
        else if(flightTicket.getBookingClass() == "BC") {
            selFlight = flightScheduleRepo.findById(flightTicket.getFlightId()).get().getBussinessClassSeats();
        }
        Long availableSeats = selFlight - bookiFlightRepo.findByFlightIdAndDateOfJourneyAndBookingClass(flightTicket.getFlightId(),flightTicket.getDateOfJourney(),flightTicket.getBookingClass());
        BookFlightDto flightDto = null;
        if(availableSeats >= flightTicket.getTotTickets()) {
            BookFlightTicket bookedFlight = bookiFlightRepo.save(flightTicket);
            passangers.stream().forEach(passanger-> {
                passanger.setTicketStatus("booked");
                passanger.setBookFlightTicket(bookedFlight);
                passangerDtlRepo.save(passanger);
            });
            flightDto = flightBookingMapper.map(bookedFlight, BookFlightDto.class);
            return new ResponseEntity<String>("Booked Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<String>(availableSeats+" Seats are available", HttpStatus.IM_USED);
    }
}
