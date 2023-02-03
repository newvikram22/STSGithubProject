package com.restapi.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.demo.controller.flightController;
import com.restapi.demo.model.Flight;
import com.restapi.demo.repository.FlightRepository;
import com.restapi.demo.service.FlightService;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class FlightControllerTest {
	
	private static MockMvc mockmvc;
	
	
	 @Autowired
	 private ObjectMapper mapper = new ObjectMapper();

	
	//ObjectWriter objwriter = objmapper.writer();
	
	//@Mock
	//private FlightRepository flightrepository;
	
	@InjectMocks
	private flightController flightcontroller;
	

	@Mock
	private FlightService flightService;
	
	@Mock
	private FlightRepository flightRepository;
	
	
	@BeforeEach
	public void setUp()
	{
		//MockitoAnnotations.openMocks(this);
		MockitoAnnotations.initMocks(this) ;
		mockmvc = MockMvcBuilders.standaloneSetup(flightcontroller).build();
	
	  //  mockmvc = MockMvcBuilders.standaloneSetup(flightcontroller).build();
	}
	@Test
	@DisplayName("Get all Flight Details")
	public void getAllFlights_success() throws Exception 
	{

		

		DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		
		Flight f1 = new Flight(new Date(),"A1","DXB","BMO", new java.sql.Time(formatter.parse("12:00:00").getTime()),new java.sql.Time(formatter.parse("14:00:00").getTime()));
		Flight f2 = new Flight(new Date(),"A2","DXB","BMO", new java.sql.Time(formatter.parse("12:00:00").getTime()),new java.sql.Time(formatter.parse("14:00:00").getTime()));
		Flight f3 = new Flight(new Date(),"A3","DXB","BMO", new java.sql.Time(formatter.parse("12:00:00").getTime()),new java.sql.Time(formatter.parse("14:00:00").getTime()));
		

		
		//List<Flight> all = new ArrayList<>(Arrays.asList(f1,f2,f3)); 
		
		List<Flight> flights = new ArrayList<Flight>();
		flights.add(f1);flights.add(f2);flights.add(f3);
		Mockito.when(flightService.getAllFlight()).thenReturn(flights);
		this.mockmvc.perform(MockMvcRequestBuilders.get("/flights").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$[2].flightNo", is("A3")));
		
		
		
      
				
	}
  @Test
  @DisplayName("Create Flight Details")
	public void CreateFlightDetails() throws Exception 
	{
		
	DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		
		Flight f1 = new Flight(new Date(),"A1","BOM","JFK", new java.sql.Time(formatter.parse("12:00:00").getTime()),new java.sql.Time(formatter.parse("14:00:00").getTime()));
		//Mockito.when(flightService.saveFlight(f1)).thenReturn(f1);

		System.out.print(mapper.writeValueAsString(f1));
		ResultActions response = this.mockmvc.perform(post("/flight")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(mapper.writeValueAsString(f1)));

	        // then - verify the result or output using assert statements
	        response.andDo(print()).
	        andExpect(status().isOk());
	                
	}
  
  
  @Test
  @DisplayName("search Flight Details")
	public void searchFlightDetails() throws Exception 
	{
		
	DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		
		Flight f1 = new Flight(new Date(),"A1","DXB","BMO", new java.sql.Time(formatter.parse("12:00:00").getTime()),new java.sql.Time(formatter.parse("14:00:00").getTime()));
		//Mockito.when(flightService.saveFlight(f1)).thenReturn(f1);
		//Mockito.when(flightService.getAllFlight()).thenReturn((List<Flight>) f1);

		System.out.print(mapper.writeValueAsString(f1));
		ResultActions response = this.mockmvc.perform(post("/search")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(mapper.writeValueAsString(f1)));

	        // then - verify the result or output using assert statements
	        response.andDo(print()).
	        andExpect(status().isOk());
	                  
	}
	

}
