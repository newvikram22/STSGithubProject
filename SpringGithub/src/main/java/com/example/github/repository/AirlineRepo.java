package com.example.github.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.github.model.Airline;

@Repository
public interface AirlineRepo extends JpaRepository<Airline, Integer>{

	
	@Query(value = "select * from airline where arrival=?1 and departure=?2", nativeQuery = true)
	public List<Airline> searchFlight(String arrival,String departure);
}
