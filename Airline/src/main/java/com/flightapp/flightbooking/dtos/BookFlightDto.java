package com.flightapp.flightbooking.dtos;

import java.util.Set;

public class BookFlightDto {
	private long id;
	private long numberOfBooking;
	private Set<PassangerDtlDto> passangerDlt;
	private long loggedInUserId;
	private long flightId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNumberOfBooking() {
		return numberOfBooking;
	}
	public void setNumberOfBooking(long numberOfBooking) {
		this.numberOfBooking = numberOfBooking;
	}
	public Set<PassangerDtlDto> getPassangerDlt() {
		return passangerDlt;
	}
	public void setPassangerDlt(Set<PassangerDtlDto> passangerDlt) {
		this.passangerDlt = passangerDlt;
	}
	public long getLoggedInUserId() {
		return loggedInUserId;
	}
	public void setLoggedInUserId(long loggedInUserId) {
		this.loggedInUserId = loggedInUserId;
	}
	public long getFlightId() {
		return flightId;
	}
	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}
}
