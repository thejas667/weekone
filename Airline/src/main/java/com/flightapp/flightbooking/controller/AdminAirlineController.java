package com.flightapp.flightbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.flightbooking.dtos.AirlineDto;
import com.flightapp.services.AirlineService;

@RestController
@RequestMapping("/admin")
public class AdminAirlineController {
	
	@Autowired
	private AirlineService airlineService;
	
	@PostMapping("/saveAirline")
	@PreAuthorize("hasRole('ADMIN')")
	public AirlineDto saveAirline(@RequestBody AirlineDto airlineDto) {
		AirlineDto saveAirline = airlineService.saveAirline(airlineDto);
		return saveAirline;
	}
	
	@PutMapping("/deleteAirline")
	@PreAuthorize("hasRole('ADMIN')")
	public Boolean deleteAirline(String airLineName) {
		Boolean deleteAirline = airlineService.deleteAirline(airLineName);
		return deleteAirline;
		
	}
}
