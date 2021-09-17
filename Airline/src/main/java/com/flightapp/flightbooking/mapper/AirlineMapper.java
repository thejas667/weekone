package com.flightapp.flightbooking.mapper;

import com.flightapp.flightbooking.models.Address;
import com.flightapp.flightbooking.models.FlightSchedule;
import org.springframework.stereotype.Component;

import com.flightapp.flightbooking.dtos.AddressDto;
import com.flightapp.flightbooking.dtos.AirlineDto;
import com.flightapp.flightbooking.dtos.FlightScedulDto;
import com.flightapp.flightbooking.models.Airline;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class AirlineMapper extends ConfigurableMapper{

	@Override
	protected void configure(MapperFactory factory) {
		super.configure(factory);
		factory.registerClassMap(
				factory.classMap(AirlineDto.class, Airline.class)
				.byDefault()
				.customize(new AddressCustomMapper())
				.toClassMap()
				);
	}
}

class AddressCustomMapper extends CustomMapper<AirlineDto, Airline>{
	@Override
	public void mapAtoB(final AirlineDto airlineDto,final Airline airline, MappingContext context) {
		airline.getOwnerAddress().clear();
		airlineDto.getOwnerAddress().forEach(addressDto->{
			Address address = new Address();
			address.setCity(addressDto.getCity());
			address.setPinCode(addressDto.getPinCode());
			address.setStreet(addressDto.getStreet());
			address.setState(addressDto.getState());
			airline.getOwnerAddress().add(address);
		});
		airline.getFlightSchedules().clear();
		airlineDto.getFlights().forEach(flightsDto->{
			FlightSchedule flightSchedule = new FlightSchedule();
			flightSchedule.setTakeOff(flightsDto.getTakeOff());
			flightSchedule.setLandingTime(flightsDto.getTakeOff());
			flightSchedule.setAirCraft(flightsDto.getAirCraft());
			flightSchedule.setDays(flightsDto.getDays());
			flightSchedule.setBussinessClassSeats(flightsDto.getBussinessClassSeats());
			flightSchedule.setBussinessClassSeatCost(flightsDto.getBussinessClassSeatCost());
			flightSchedule.setFirstClassSeats(flightsDto.getFirstClassSeats());
			flightSchedule.setFirstClassSeatCost(flightsDto.getFirstClassSeatCost());
			flightSchedule.setSecondClassSeats(flightsDto.getSecondClassSeats());
			flightSchedule.setSecondClassSeatCost(flightsDto.getSecondClassSeatCost());
			flightSchedule.setThirdClassSeats(flightsDto.getThirdClassSeats());
			flightSchedule.setThirdClassSeatCost(flightsDto.getThirdClassSeatCost());
			flightSchedule.setMeal(flightsDto.getMeal());
			flightSchedule.setFromCity(flightsDto.getFromCity());
			flightSchedule.setToCity(flightsDto.getToCity());
			airline.getFlightSchedules().add(flightSchedule);
		});
	}

	@Override
	public void mapBtoA(final Airline airline,final AirlineDto airlineDto, MappingContext context) {
		airlineDto.getOwnerAddress().clear();
		airline.getOwnerAddress().forEach(address->{
			AddressDto addressDto = new AddressDto();
			addressDto.setCity(address.getCity());
			addressDto.setPinCode(address.getPinCode());
			addressDto.setStreet(address.getStreet());
			addressDto.setState(address.getState());
			airlineDto.getOwnerAddress().add(addressDto);
		});
		
		
		airlineDto.getFlights().clear();
		airline.getFlightSchedules().forEach(flightSchedule->{
			FlightScedulDto flightScheduleDto = new FlightScedulDto();
			flightScheduleDto.setTakeOff(flightSchedule.getTakeOff());
			flightScheduleDto.setLandingTime(flightSchedule.getTakeOff());
			flightScheduleDto.setAirCraft(flightSchedule.getAirCraft());
			flightScheduleDto.setDays(flightSchedule.getDays());
			flightScheduleDto.setBussinessClassSeats(flightSchedule.getBussinessClassSeats());
			flightScheduleDto.setBussinessClassSeatCost(flightSchedule.getBussinessClassSeatCost());
			flightScheduleDto.setFirstClassSeats(flightSchedule.getFirstClassSeats());
			flightScheduleDto.setFirstClassSeatCost(flightSchedule.getFirstClassSeatCost());
			flightScheduleDto.setSecondClassSeats(flightSchedule.getSecondClassSeats());
			flightScheduleDto.setSecondClassSeatCost(flightSchedule.getSecondClassSeatCost());
			flightScheduleDto.setThirdClassSeats(flightSchedule.getThirdClassSeats());
			flightScheduleDto.setThirdClassSeatCost(flightSchedule.getThirdClassSeatCost());
			flightScheduleDto.setMeal(flightSchedule.getMeal());
			flightScheduleDto.setFromCity(flightSchedule.getFromCity());
			flightScheduleDto.setToCity(flightSchedule.getToCity());
			airlineDto.getFlights().add(flightScheduleDto);
		});
	}
}

