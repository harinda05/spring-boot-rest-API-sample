package com.springnew.spring.flight;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Flights {
	public List<Flight> flights;

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
}
