package com.flightapp.flightbooking.dtos;

import java.time.LocalTime;

public class FlightScedulDto {
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
	
	public LocalTime getTakeOff() {
		return takeOff;
	}

	public void setTakeOff(LocalTime takeOff) {
		this.takeOff = takeOff;
	}

	public LocalTime getLandingTime() {
		return landingTime;
	}

	public void setLandingTime(LocalTime landingTime) {
		this.landingTime = landingTime;
	}

	public Long getAirCraft() {
		return airCraft;
	}

	public void setAirCraft(Long airCraft) {
		this.airCraft = airCraft;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public Long getBussinessClassSeats() {
		return bussinessClassSeats;
	}

	public void setBussinessClassSeats(Long bussinessClassSeats) {
		this.bussinessClassSeats = bussinessClassSeats;
	}

	public Double getBussinessClassSeatCost() {
		return bussinessClassSeatCost;
	}

	public void setBussinessClassSeatCost(Double bussinessClassSeatCost) {
		this.bussinessClassSeatCost = bussinessClassSeatCost;
	}

	public Long getFirstClassSeats() {
		return firstClassSeats;
	}

	public void setFirstClassSeats(Long firstClassSeats) {
		this.firstClassSeats = firstClassSeats;
	}

	public Double getFirstClassSeatCost() {
		return firstClassSeatCost;
	}

	public void setFirstClassSeatCost(Double firstClassSeatCost) {
		this.firstClassSeatCost = firstClassSeatCost;
	}

	public Long getSecondClassSeats() {
		return secondClassSeats;
	}

	public void setSecondClassSeats(Long secondClassSeats) {
		this.secondClassSeats = secondClassSeats;
	}

	public Double getSecondClassSeatCost() {
		return secondClassSeatCost;
	}

	public void setSecondClassSeatCost(Double secondClassSeatCost) {
		this.secondClassSeatCost = secondClassSeatCost;
	}

	public Long getThirdClassSeats() {
		return thirdClassSeats;
	}

	public void setThirdClassSeats(Long thirdClassSeats) {
		this.thirdClassSeats = thirdClassSeats;
	}

	public Double getThirdClassSeatCost() {
		return thirdClassSeatCost;
	}

	public void setThirdClassSeatCost(Double thirdClassSeatCost) {
		this.thirdClassSeatCost = thirdClassSeatCost;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public Long getFromCity() {
		return fromCity;
	}

	public void setFromCity(Long fromCity) {
		this.fromCity = fromCity;
	}

	public Long getToCity() {
		return toCity;
	}

	public void setToCity(Long toCity) {
		this.toCity = toCity;
	}
}
