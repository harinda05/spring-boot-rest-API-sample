package com.springnew.spring.flight;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {
	@Autowired
	private FlightModel model;

	@RequestMapping("/flight/get")
	public List<Flight> getPerson(@RequestParam(name="time", required=true, defaultValue="Unknown") String time) throws ParseException {		
		List<Flight>  returnFlight = model.getFlightList(time);
		return returnFlight;
	}

}
