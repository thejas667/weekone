package com.flightapp.flightbooking.dtos;

import java.util.Set;

public class AirlineDto {
	private String airlineName;
	private String ownerName;
	private String ownerMobile;
	private Set<AddressDto> ownerAddress;
	private Set<FlightScedulDto> flights;
	private String airlineLogo;
	private Long totFlights;
	private Long activeFlights;
	private String status;
	public Set<FlightScedulDto> getFlights() {
		return flights;
	}
	public void setFlights(Set<FlightScedulDto> flights) {
		this.flights = flights;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerMobile() {
		return ownerMobile;
	}
	public void setOwnerMobile(String ownerMobile) {
		this.ownerMobile = ownerMobile;
	}
	public Set<AddressDto> getOwnerAddress() {
		return ownerAddress;
	}
	public void setOwnerAddress(Set<AddressDto> ownerAddress) {
		this.ownerAddress = ownerAddress;
	}
	public String getAirlineLogo() {
		return airlineLogo;
	}
	public void setAirlineLogo(String airlineLogo) {
		this.airlineLogo = airlineLogo;
	}
	public Long getTotFlights() {
		return totFlights;
	}
	public void setTotFlights(Long totFlights) {
		this.totFlights = totFlights;
	}
	public Long getActiveFlights() {
		return activeFlights;
	}
	public void setActiveFlights(Long activeFlights) {
		this.activeFlights = activeFlights;
	}
	
}
