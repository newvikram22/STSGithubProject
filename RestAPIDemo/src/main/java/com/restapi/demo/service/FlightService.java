package com.restapi.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.demo.model.Flight;
import com.restapi.demo.repository.FlightRepository;

@Service
public class FlightService {
	
	
	@Autowired
    FlightRepository flightReposittory;
	
	
	public Flight saveFlight(Flight flight)
	{
		Flight newflight = flightReposittory.save(flight);
		return newflight;
	}
	
	public List<Flight> getAllFlight()
	{
		return flightReposittory.findAll();
	}

}
