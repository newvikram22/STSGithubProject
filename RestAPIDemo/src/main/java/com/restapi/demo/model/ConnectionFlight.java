package com.restapi.demo.model;

import java.sql.Time;
import java.util.Date;

public class ConnectionFlight {

	
	private String flightDate;
	private String flightNo;
	private String departureAirport;
	private String arrivalAirport;
	private Time departureTime;
	private Time arrivalTime;
	
	private String   connFTflightDate;
	private String connFTflightNo;
	private String connFTdepartureAirport;
	private String connFTarrivalAirport;
	private Time connFTdepartureTime;
	private Time connFTarrivalTime;
	
	private long layoverTime;
	
	
	
	public long getLayoverTime() {
		return layoverTime;
	}
	public void setLayoverTime(long layoverTime) {
		this.layoverTime = layoverTime;
	}
	public ConnectionFlight() {
		super();
	}
	
	
	//first_leg.arrival_airport,first_leg.arrival_time,first_leg.departure_airport,first_leg.departure_time,first_leg.flight_date,first_leg.flight_no,second_leg.arrival_airport,second_leg.arrival_time,second_leg.departure_airport,second_leg.departure_time,second_leg.flight_date,second_leg.flight_no,
	
	
	@Override
	public String toString() {
		return "ConnectionFlight [flightDate=" + flightDate + ", flightNo=" + flightNo + ", departureAirport="
				+ departureAirport + ", arrivalAirport=" + arrivalAirport + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", connFTflightDate=" + connFTflightDate + ", connFTflightNo="
				+ connFTflightNo + ", connFTdepartureAirport=" + connFTdepartureAirport + ", connFTarrivalAirport="
				+ connFTarrivalAirport + ", connFTdepartureTime=" + connFTdepartureTime + ", connFTarrivalTime="
				+ connFTarrivalTime + "]";
	}
	public ConnectionFlight(String flightDate, String flightNo, String departureAirport,Time departureTime, String arrivalAirport,
			 Time arrivalTime, String connFTflightDate, String connFTflightNo,
			String connFTdepartureAirport, Time connFTdepartureTime, String connFTarrivalAirport,
			Time connFTarrivalTime, long layoverTime) {
		super();
		this.flightDate = flightDate;
		this.flightNo = flightNo;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.connFTflightDate = connFTflightDate;
		this.connFTflightNo = connFTflightNo;
		this.connFTdepartureAirport = connFTdepartureAirport;
		this.connFTarrivalAirport = connFTarrivalAirport;
		this.connFTdepartureTime = connFTdepartureTime;
		this.connFTarrivalTime = connFTarrivalTime;
		this.layoverTime = layoverTime;
	}
	public String getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(String flightDate) {
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
	public String getConnFTflightDate() {
		return connFTflightDate;
	}
	public void setConnFTflightDate(String connFTflightDate) {
		this.connFTflightDate = connFTflightDate;
	}
	public String getConnFTflightNo() {
		return connFTflightNo;
	}
	public void setConnFTflightNo(String connFTflightNo) {
		this.connFTflightNo = connFTflightNo;
	}
	public String getConnFTdepartureAirport() {
		return connFTdepartureAirport;
	}
	public void setConnFTdepartureAirport(String connFTdepartureAirport) {
		this.connFTdepartureAirport = connFTdepartureAirport;
	}
	public String getConnFTarrivalAirport() {
		return connFTarrivalAirport;
	}
	public void setConnFTarrivalAirport(String connFTarrivalAirport) {
		this.connFTarrivalAirport = connFTarrivalAirport;
	}
	public Time getConnFTdepartureTime() {
		return connFTdepartureTime;
	}
	public void setConnFTdepartureTime(Time connFTdepartureTime) {
		this.connFTdepartureTime = connFTdepartureTime;
	}
	public Time getConnFTarrivalTime() {
		return connFTarrivalTime;
	}
	public void setConnFTarrivalTime(Time connFTarrivalTime) {
		this.connFTarrivalTime = connFTarrivalTime;
	}
	
	
	
}
