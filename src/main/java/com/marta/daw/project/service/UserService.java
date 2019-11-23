package com.marta.daw.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.marta.daw.project.model.Login;
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

	public ResponseEntity<?> login(Login login) {
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

	public ResponseEntity<?> getStatsByUserId(int id) {
		UserStats userStats = new UserStats();
		userStats.setCheaperTrip(tripRepository.findTopByUserIdOrderByPriceAsc(id));
		userStats.setMoreExpensiveTrip(tripRepository.findTopByUserIdOrderByPriceDesc(id));
		return new ResponseEntity<UserStats>(userStats, HttpStatus.OK);
	}
}
