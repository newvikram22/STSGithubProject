package com.restapi.demo.model;


import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private Date   flightDate;
	private String flightNo;
	private String departureAirport;
	private String arrivalAirport;
	private Time departureTime;
	private Time arrivalTime;
	
	
	
	public Flight() {
		super();
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightDate=" + flightDate + ", flightNo=" + flightNo + ", departureAirport="
				+ departureAirport + ", arrivalAirport=" + arrivalAirport + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + "]";
	}
	public Flight(Date flightDate, String flightNo, String departureAirport, String arrivalAirport,
			Time departureTime, Time arrivalTime) {
		super();
		this.flightDate = flightDate;
		this.flightNo = flightNo;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}
	public String getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	public Time getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}
	public Time getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

}
