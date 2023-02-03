package com.example.github.model;




import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@jakarta.persistence.Entity

public class Airline {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String flightNo;
	private String Arrival;
	private String Departure;
	private String arrivalTime;
	private String departureTime;
	public Airline() {}
	public Airline(String flightNo, String arrival, String departure, String arrivalTime, String departureTime) {
		super();
		this.flightNo = flightNo;
		this.	Arrival = arrival;
		this.Departure = departure;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getArrival() {
		return Arrival;
	}
	public void setArrival(String arrival) {
		Arrival = arrival;
	}
	public String getDeparture() {
		return Departure;
	}
	public void setDeparture(String departure) {
		Departure = departure;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
	
	
}
