package com.flightapp.flightbooking.models;

import lombok.Data;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "flight_schedule")
public class FlightSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long flightCode;
	
	private LocalTime takeOff;
	
	private LocalTime landingTime;
	
	private Long airCraft;
	
	private String days;
	
	private Long bussinessClassSeats;
	
	private Double bussinessClassSeatCost;
	
	private Long firstClassSeats;
	
	private Double firstClassSeatCost;
	
	private Long secondClassSeats;
	
	private Double secondClassSeatCost;
	
	private Long thirdClassSeats;
	
	private Double thirdClassSeatCost;
	
	private String meal;
	
	private Long fromCity;
	
	private Long toCity;
	


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "airline_fk", nullable = false)
	private Airline airline;

}
