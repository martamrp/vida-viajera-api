package com.marta.daw.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marta.daw.project.model.Trip;
import com.marta.daw.project.model.TripRepository;

@RestController
@RequestMapping(path="trip")
public class TripController {
	
	@Autowired
	TripRepository tripRepository;

	@RequestMapping(path="{userId}", method=RequestMethod.GET)
	public List<Trip> getTrips(@PathVariable int userId) {
		//return tripRepository.findByUserId(userId);
		return tripRepository.findByUserId(userId);
	}
	/*
	@RequestMapping(value="trip", method=RequestMethod.PUT)
	public void update(@PathVariable int tripId, @RequestBody Trip trip) {
		
	}
	
	@RequestMapping(value="trip", method=RequestMethod.DELETE)
	public void delete(@PathVariable int tripId) {
		
	}
	
	@RequestMapping(value="trip", method=RequestMethod.POST)
	public void create(@RequestBody Trip trip) {
		
	}*/
	
}
