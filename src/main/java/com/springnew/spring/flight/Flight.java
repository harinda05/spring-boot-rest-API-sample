package com.springnew.spring.flight;

import org.springframework.stereotype.Component;

@Component
public class Flight {
	
	private String flight;
	private String departure;
	
	public String getFlight() {
		return flight;
	}
	public void setFlight(String flight) {
		this.flight = flight;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	
}
