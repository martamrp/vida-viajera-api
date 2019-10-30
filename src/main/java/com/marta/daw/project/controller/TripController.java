package com.marta.daw.project.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		return tripRepository.findByUserId(userId);
	}
	
	@RequestMapping(path="{id}", method=RequestMethod.PUT)
	public Trip updateTrip(@PathVariable int id, @RequestBody Trip trip) {
		tripRepository.findById(id);
		return tripRepository.save(trip);
		
	}
	
	@RequestMapping(path="{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteTrip(@PathVariable int id) {
		if(tripRepository.existsById(id)==true) {
			tripRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> createTrip(@RequestBody Trip trip) {
		Date startDate = trip.getStartDate();
		Date endDate = trip.getEndDate();

		if(endDate.before(startDate)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}else if(tripRepository.findByReasonId(trip.getReasonId())==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		else {
			Trip createdTrip = tripRepository.save(trip);
			return new ResponseEntity<Trip>(createdTrip, HttpStatus.CREATED);
		}	
	}
		
		
	
	
}
