package com.flightapp.flightbooking.models;

import lombok.Data;

import java.time.LocalDate;


@Data
public class SearchFlight {
	private long toCity;
	private long fromCity;
	private LocalDate journeyDate;
	private String bookingClass;


}
