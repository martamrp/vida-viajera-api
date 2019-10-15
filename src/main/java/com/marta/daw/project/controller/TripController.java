package com.marta.daw.project.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marta.daw.project.model.Trip;

@RestController
public class TripController {

	@RequestMapping(value="trip", method=RequestMethod.GET)
	public Trip getTrips(@PathVariable int userId) {
		return new Trip();
	}
	
	@RequestMapping(value="trip", method=RequestMethod.PUT)
	public void update(@PathVariable int tripId, @RequestBody Trip trip) {
		
	}
	
	@RequestMapping(value="trip", method=RequestMethod.DELETE)
	public void delete(@PathVariable int tripId) {
		
	}
	
	@RequestMapping(value="trip", method=RequestMethod.POST)
	public void create(@RequestBody Trip trip) {
		
	}
	
}
