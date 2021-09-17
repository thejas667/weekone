package com.flightapp.flightbooking.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@Entity
public class Airline implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String airlineName;
	
	private String ownerName;
	
	private String ownerMobile;
	
	@OneToMany(mappedBy = "airline", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Address> ownerAddress;
	
	@OneToMany(mappedBy = "airline", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<FlightSchedule> flightSchedules;
	
	private String airlineLogo;
	
	private Long totFlights;
	
	private Long activeFlights;
	
	private String status;


}
