package com.flightapp.flightbooking.dtos;

import lombok.Data;

@Data
public class PassangerDtlDto {
	private String passangerName;
	private long passangerAge;
	private String foodType;
	private Character gender;
	private String ticketStatus;

}
