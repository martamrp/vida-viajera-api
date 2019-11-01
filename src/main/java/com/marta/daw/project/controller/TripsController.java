package com.marta.daw.project.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marta.daw.project.model.ReasonRepository;
import com.marta.daw.project.model.Trip;
import com.marta.daw.project.model.TripRepository;
import com.marta.daw.project.model.UserRepository;

@RestController
@RequestMapping(path = "trips")
public class TripsController {

	@Autowired
	TripRepository tripRepository;
	@Autowired
	ReasonRepository reasonRepository;
	@Autowired
	UserRepository userRepository;

	@RequestMapping(path = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateTrip(@PathVariable int id, @RequestBody Trip trip) {
		Date startDate = trip.getStartDate();
		Date endDate = trip.getEndDate();

		if (endDate.before(startDate)) {
			return new ResponseEntity<>("La fecha fin es anterior a la fecha de inicio del viaje",
					HttpStatus.BAD_REQUEST);
		}
		
		if(id != trip.getId()) {
			return new ResponseEntity<>("El id del viaje no se puede modificar", HttpStatus.BAD_REQUEST);
		}
		
		Optional<Trip> tripBD = tripRepository.findById(id);
		// COMPROBAR SI EL ID DE USUARIO QUE LE PASO ES IGUAL AL ID DE USUARIO QUE ESTÁ EN BASE DE DATOS
		if(trip.getUserId() != tripBD.get().getUserId()) {
			return new ResponseEntity<>("El id del usuario no se puede modificar", HttpStatus.BAD_REQUEST);
		}

		if(!tripRepository.existsById(trip.getId())) {
			return new ResponseEntity<>("El viaje no existe", HttpStatus.BAD_REQUEST);
		}
		
		if (!reasonRepository.existsById(trip.getReasonId())) {
			return new ResponseEntity<>("La razón que has introducido no existe", HttpStatus.BAD_REQUEST);
		}

		if (!userRepository.existsById(trip.getUserId())) {
			return new ResponseEntity<>("El usuario no existe", HttpStatus.BAD_REQUEST);
		}

		if (tripRepository.existsByOriginAndDestinationAndStartDateAndEndDate(trip.getOrigin(), trip.getDestination(),
				trip.getStartDate(), trip.getEndDate())) {
			return new ResponseEntity<>("El viaje ya existe", HttpStatus.BAD_REQUEST);
		}
		
		//tripRepository.findById(id);
		return new ResponseEntity<Trip>(tripRepository.save(trip), HttpStatus.OK);
	}

	@RequestMapping(path = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteTrip(@PathVariable int id) {
		if (!tripRepository.existsById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		tripRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createTrip(@RequestBody Trip trip) {
		Date startDate = trip.getStartDate();
		Date endDate = trip.getEndDate();

		if (endDate.before(startDate)) {
			return new ResponseEntity<>("La fecha fin es anterior a la fecha de inicio del viaje",
					HttpStatus.BAD_REQUEST);
		}

		if (!reasonRepository.existsById(trip.getReasonId())) {
			return new ResponseEntity<>("La razón que has introducido no existe", HttpStatus.BAD_REQUEST);
		}

		if (!userRepository.existsById(trip.getUserId())) {
			return new ResponseEntity<>("El usuario no existe", HttpStatus.BAD_REQUEST);
		}

		if (tripRepository.existsByOriginAndDestinationAndStartDateAndEndDate(trip.getOrigin(), trip.getDestination(),
				trip.getStartDate(), trip.getEndDate())) {
			return new ResponseEntity<>("El viaje ya existe", HttpStatus.BAD_REQUEST);
		}

		Trip createdTrip = tripRepository.save(trip);
		return new ResponseEntity<Trip>(createdTrip, HttpStatus.CREATED);
	}

}
