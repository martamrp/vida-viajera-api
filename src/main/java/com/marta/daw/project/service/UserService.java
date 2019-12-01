package com.marta.daw.project.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	public ResponseEntity<User> login(Login login) {
		List<User> userDB = userRepository.findByUsername(login.getUsername());
		if (userDB.isEmpty()) {
			User user = new User();
			user.setUsername(login.getUsername());

			return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
		}
		return new ResponseEntity<>(userDB.get(0), HttpStatus.OK);
	}

	public ResponseEntity<?> getTripsByUserId(int id) {
		if (!userRepository.existsById(id)) {
			return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(tripRepository.findByUserId(id), HttpStatus.OK);
	}

	public ResponseEntity<UserStats> getStatsByUserId(int id) {
		UserStats userStats = new UserStats();
		userStats.setCheapestTrip(tripRepository.findTopByUserIdOrderByPriceAsc(id));
		userStats.setMostExpensiveTrip(tripRepository.findTopByUserIdOrderByPriceDesc(id));
		userStats.setLeisureTrips(tripRepository.findByUserIdAndReasonId(id, 1).size());
		userStats.setBusinessTrips(tripRepository.findByUserIdAndReasonId(id, 3).size());
		userStats.setShortestTrip(tripRepository.findTripsByUserIdOrderByDurationAsc(id).get(0));
		userStats.setLongestTrip(tripRepository.findTripsByUserIdOrderByDurationDesc(id).get(0));
		userStats.setCheapestTripPerDay(tripRepository.findTripsByUserIdOrderByPricePerDayAsc(id).get(0));
		userStats.setMostExpensiveTripPerDay(tripRepository.findTripsByUserIdOrderByPricePerDayDesc(id).get(0));
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
