package com.marta.daw.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marta.daw.project.repository.ReasonRepository;
import com.marta.daw.project.model.Trip;
import com.marta.daw.project.repository.TripRepository;
import com.marta.daw.project.repository.UserRepository;
import com.marta.daw.project.service.TripService;

@RestController
@RequestMapping(path = "trips")
public class TripsController {

	@Autowired
	TripService tripService;
	@Autowired
	TripRepository tripRepository;
	@Autowired
	ReasonRepository reasonRepository;
	@Autowired
	UserRepository userRepository;

	@RequestMapping(path = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateTrip(@PathVariable int id, @RequestBody Trip trip) {

		return tripService.updateTrip(id, trip);
	}

	@RequestMapping(path = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteTrip(@PathVariable int id) {

		return tripService.deleteTrip(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createTrip(@RequestBody Trip trip) {

		return tripService.createTrip(trip);
	}
}
