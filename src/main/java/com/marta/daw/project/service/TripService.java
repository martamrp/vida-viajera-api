package com.marta.daw.project.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.marta.daw.project.repository.ReasonRepository;
import com.marta.daw.project.model.Trip;
import com.marta.daw.project.repository.TripRepository;
import com.marta.daw.project.repository.UserRepository;

@Service
public class TripService {
	
	@Autowired
	TripRepository tripRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ReasonRepository reasonRepository;

	public ResponseEntity<?> updateTrip(int id, Trip trip) {
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

		if (tripRepository.existsByOriginAndDestinationAndStartDateAndEndDateAndUserId(trip.getOrigin(), trip.getDestination(),
				trip.getStartDate(), trip.getEndDate(), trip.getUserId())) {
			return new ResponseEntity<>("El viaje ya existe", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Trip>(tripRepository.save(trip), HttpStatus.OK);
	}
	
	public ResponseEntity<?> deleteTrip(int id) {
		if (!tripRepository.existsById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		tripRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	public ResponseEntity<?> createTrip(Trip trip) {
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

		if (tripRepository.existsByOriginAndDestinationAndStartDateAndEndDateAndUserId(trip.getOrigin(), trip.getDestination(),
				trip.getStartDate(), trip.getEndDate(), trip.getUserId())) {
			return new ResponseEntity<>("El viaje ya existe", HttpStatus.CONFLICT);
		}

		Trip createdTrip = tripRepository.save(trip);
		return new ResponseEntity<Trip>(createdTrip, HttpStatus.CREATED);
	}
}
