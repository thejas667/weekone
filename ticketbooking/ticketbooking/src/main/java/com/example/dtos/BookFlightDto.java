package com.example.dtos;

import lombok.Data;

import java.util.Set;

@Data
public class BookFlightDto {

    private long id;
    private long numberOfBooking;
    private Set<PassangerDtlDto> passangerDlt;
    private long loggedInUserId;
    private long flightId;

}
