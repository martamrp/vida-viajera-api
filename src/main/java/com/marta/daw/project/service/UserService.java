package com.marta.daw.project.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marta.daw.project.model.Login;
import com.marta.daw.project.model.Trip;
import com.marta.daw.project.repository.RegionRepository;
import com.marta.daw.project.repository.TripRepository;
import com.marta.daw.project.model.User;
import com.marta.daw.project.model.UserStats;
import com.marta.daw.project.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	TripRepository tripRepository;
	@Autowired
	RegionRepository regionRepository;

	public ResponseEntity<?> login(Login login) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User userDB = userRepository.findFirstByUsername(login.getUsername());
		
		if (userDB == null) {
			User newUser = new User();
			newUser.setUsername(login.getUsername());
			newUser.setPassword(passwordEncoder.encode(login.getPassword()));
			
			User createdUser = userRepository.save(newUser);
			
			User user = new User();
			user.setId(createdUser.getId());
			user.setUsername(createdUser.getUsername());

			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
		
		if(passwordEncoder.matches(login.getPassword(), userDB.getPassword())) {
			User user = new User();
			user.setId(userDB.getId());
			user.setUsername(userDB.getUsername());
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Contraseña incorrecta", HttpStatus.BAD_REQUEST);
		}		
	}

	public ResponseEntity<?> getTripsByUserId(int id) {
		if (!userRepository.existsById(id)) {
			return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(tripRepository.findByUserId(id), HttpStatus.OK);
	}

	public ResponseEntity<?> getStatsByUserId(int id) {
		if (!userRepository.existsById(id)) {
			return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
		}
		
		UserStats userStats = new UserStats();
		List<Trip> trips = null;
		userStats.setCheapestTrip(tripRepository.findTopByUserIdOrderByPriceAsc(id));
		userStats.setMostExpensiveTrip(tripRepository.findTopByUserIdOrderByPriceDesc(id));
		userStats.setLeisureTrips(tripRepository.findByUserIdAndReasonId(id, 1).size());
		userStats.setBusinessTrips(tripRepository.findByUserIdAndReasonId(id, 3).size());
		
		trips = tripRepository.findTripsByUserIdOrderByDurationAsc(id);
		if(!trips.isEmpty()) {
			userStats.setShortestTrip(trips.get(0));	
		}
		
		trips = tripRepository.findTripsByUserIdOrderByDurationDesc(id);
		if(!trips.isEmpty()) {
			userStats.setLongestTrip(trips.get(0));	
		}
		
		trips = tripRepository.findTripsByUserIdOrderByPricePerDayAsc(id);
		if(!trips.isEmpty()) {
			userStats.setCheapestTripPerDay(trips.get(0));	
		}
		
		trips = tripRepository.findTripsByUserIdOrderByPricePerDayDesc(id);
		if(!trips.isEmpty()) {
			userStats.setMostExpensiveTripPerDay(trips.get(0));	
		}

		return new ResponseEntity<>(userStats, HttpStatus.OK);
	}

	public ResponseEntity<?> getCountriesByUserId(int id) {
		if (!userRepository.existsById(id)) {
			return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
		}
		
		List<Trip> trips = tripRepository.findByUserId(id);
		List<String> countries = getDistinctOriginCountries(trips);
		countries = addDistinctDestinationCountries(countries, trips);
		Collections.sort(countries);

		return new ResponseEntity<>(countries, HttpStatus.OK);
	}
	
	private List<String> getDistinctOriginCountries(List<Trip> trips){
		List<String> originCountries = new ArrayList<String>();
		for (Trip trip : trips) {
			String originCountry = trip.getOriginCountry();
			if(!originCountries.contains(originCountry)) {
				originCountries.add(originCountry);
			}
		}
		return originCountries;
	}
	
	private List<String> addDistinctDestinationCountries(List<String> countries, List<Trip> trips){
		for (Trip trip : trips) {
			String destinationCountry = trip.getDestinationCountry();
			if(!countries.contains(destinationCountry)) {
				countries.add(destinationCountry);
			}
		}
		return countries;
	}

	public ResponseEntity<?> getRegionsByUserId(int id) {
		if (!userRepository.existsById(id)) {
			return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(regionRepository.findRegionsByUserId(id), HttpStatus.OK);
	}
}
