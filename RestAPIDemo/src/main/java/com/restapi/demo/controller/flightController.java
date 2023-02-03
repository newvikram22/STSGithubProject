package com.restapi.demo.controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.demo.exception.ErrorMsgDetails;
import com.restapi.demo.exception.FlightException;
import com.restapi.demo.exception.FlightExceptionController;
import com.restapi.demo.exception.FlightNotAvailable;
import com.restapi.demo.model.ConnectionFlight;
import com.restapi.demo.model.Flight;
import com.restapi.demo.repository.FlightRepository;
import com.restapi.demo.service.FlightService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@RestController
public class flightController {
	
	@Autowired
	FlightService flightService;
	
	@Autowired
    FlightRepository flightReposittory;
	
	private static final Logger logger = LogManager.getLogger(flightController.class);
	
	@PostMapping("/flight")
	public ResponseEntity<?> addFlightDetails(@RequestBody Flight flight) 
	{
		logger.info("Create Filght details", "Method statred");
		//System.out.println(flight.toString());
		
		/*  Optional<Flight> addedflight= Optional.of(flightService.saveFlight(flight));
		  if(!addedflight.isPresent())
			throw new FlightException();
		  else
			  return new ResponseEntity<>(addedflight,HttpStatus.OK);*/
		try {
		Flight addedflight= flightService.saveFlight(flight);
		 // if(addedflight == null)
			//throw new FlightException();
		 // else
			  return new ResponseEntity<>(addedflight,HttpStatus.OK);}
		catch(Exception e)
		{
			throw new FlightException();
		}
		
	}
	
	@GetMapping("/flights")
	public List<Flight> getAllFlightDetails()
	{
		logger.info("Get All Filghts", "Method statred");
		return flightService.getAllFlight();
	}
	
	@PostMapping("/search")
	public ResponseEntity<Object> getSearchFlightDetails(@RequestBody Flight flight) throws FlightNotAvailable
	{
		logger.info("Search Filghts", flight.toString());
		List<Flight> directFlight=  flightReposittory.searchFlightDetails(flight.getDepartureAirport(),flight.getArrivalAirport());
	    if(directFlight.size()==0)
	    {
		
		List<ConnectionFlight> connFlightMod= new ArrayList<ConnectionFlight>();
	    	List<Object> connFlight=  flightReposittory.searchStoppageFlightDetails(flight.getDepartureAirport(),flight.getArrivalAirport());
	         for(int i=0;i<connFlight.size();i++)
	        {
	        	Object[] obj=   (Object[]) connFlight.get(i);
	        	for(int j=0;j<obj.length;j++)
	        	{
	        	//	System.out.println(obj[j]);
	        	}
	        	ConnectionFlight conobj = new ConnectionFlight(obj[0].toString(),obj[1].toString(),obj[2].toString(),(Time)obj[3], obj[4].toString(),(Time)obj[5],obj[6].toString(),obj[7].toString(),obj[8].toString(),(Time)obj[9],obj[10].toString(),(Time)obj[11],(int)obj[12]);
	      
	        	
	        	
	        	connFlightMod.add(conobj);
	        }
	    	 
	       if(connFlightMod.size() == 0)
	       {
	    	   throw new FlightNotAvailable("Flight not available from "+ flight.getDepartureAirport() +" to "+ flight.getArrivalAirport());
	       }
	         
	       else 
	    	return  new  ResponseEntity<>(connFlightMod,HttpStatus.OK);
	    }
	    else
	    {
	    	  if(directFlight.size() == 0)
		       {
		    	   throw new FlightNotAvailable("Flight not available from "+ flight.getDepartureAirport() +" to "+ flight.getArrivalAirport());
		       }
		         
		       else 
		    	return  new  ResponseEntity<>(directFlight,HttpStatus.OK);
	    }
	  
	}

}
