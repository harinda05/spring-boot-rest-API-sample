package com.springnew.spring.flight;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class FlightModel {
	
	
	
	public List<Flight> getFlightList(String searchTime) throws ParseException {
		
		
		List<Flight> returnListOfFlights = new ArrayList();
		
		String FlightsData = "{\r\n" + 
				"\"flights\": [\r\n" + 
				"{\r\n" + 
				"\"flight\": \"Air Canada 8099\",\r\n" + 
				"\"departure\": \"7:30AM\"\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"flight\": \"United Airline 6115\",\r\n" + 
				"\"departure\": \"10:30AM\"\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"flight\": \"WestJet 6456\",\r\n" + 
				"\"departure\": \"12:30PM\"\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"flight\": \"Delta 3833\",\r\n" + 
				"\"departure\": \"3:00PM\"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}";
		
		Gson g = new Gson();
		Flights p = g.fromJson(FlightsData, Flights.class);
		
		
		for(int i=0; i<p.getFlights().size();i++) {
			
			Flight flight = p.getFlights().get(i);
			String departure = flight.getDeparture();
			Long longDeptTime = parseTime(departure);
			Long longSearchTime = parseTime(searchTime);
			
			Long differenceL = longDeptTime - longSearchTime;
			long minutes = TimeUnit.MILLISECONDS.toMinutes(differenceL);
			
			if(differenceL>0 && minutes<300) {
				returnListOfFlights.add(flight);
			}	
			
		}
		return returnListOfFlights;
		
	}
	
	private static Long parseTime(String dateString) throws ParseException{
		SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
	    SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mma");
	    Date date = parseFormat.parse(dateString); 
	    Long longtime = date.getTime();
		return longtime;
		
	}
	
}
