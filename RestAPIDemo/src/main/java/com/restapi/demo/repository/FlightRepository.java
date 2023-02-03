package com.restapi.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restapi.demo.model.ConnectionFlight;
import com.restapi.demo.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
	
    @Query(value = "select * from flight where departure_airport = ?1 and arrival_airport = ?2", nativeQuery = true)
	public List<Flight> searchFlightDetails(String departure,String arrival);
    
    // @Query(value = "select *, second_leg.departure_time - first_leg.arrival_time as layover_time from flight first_leg inner join flight second_leg on first_leg.arrival_airport = second_leg.departure_airport where first_leg.departure_airport = ?1 and second_leg.arrival_airport = ?2 and first_leg.arrival_time < second_leg.departure_time AND second_leg.departure_time - first_leg.arrival_time between 25000 and 45000", nativeQuery = true)

    @Query(value = "SELECT first_leg.flight_date,first_leg.flight_no,first_leg.departure_airport,first_leg.departure_time,first_leg.arrival_airport,first_leg.arrival_time,first_leg.flight_date,first_leg.flight_no,first_leg.departure_airport,first_leg.departure_time,first_leg.arrival_airport,first_leg.arrival_time, second_leg.departure_time - first_leg.arrival_time as layover_time FROM flight first_leg INNER JOIN flight second_leg on first_leg.arrival_airport = second_leg.departure_airport WHERE first_leg.departure_airport = ?1 AND second_leg.arrival_airport = ?2 AND first_leg.arrival_time < second_leg.departure_time AND second_leg.departure_time - first_leg.arrival_time between 25000 and 45000", nativeQuery = true)
   	public List<Object> searchStoppageFlightDetails(String departure,String arrival);
    
    

}
