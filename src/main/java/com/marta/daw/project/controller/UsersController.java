package com.marta.daw.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marta.daw.project.model.Login;
import com.marta.daw.project.model.TripRepository;
import com.marta.daw.project.model.User;
import com.marta.daw.project.model.UserRepository;

@RestController
@RequestMapping(path = "users")
public class UsersController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TripRepository tripRepository;

	@RequestMapping(path = "login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody @Valid Login login) {
		List<User> userDB = userRepository.findByUsername(login.getUsername());
		if (userDB.isEmpty()) {
			User user = new User();
			user.setUsername(login.getUsername());

			return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
		}
		return new ResponseEntity<>(userDB.get(0), HttpStatus.OK);
	}

	@RequestMapping(path = "{id}/trips", method = RequestMethod.GET)
	public ResponseEntity<?> getTripsByUserId(@PathVariable int id) {

		if (!userRepository.existsById(id)) {
			return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(tripRepository.findByUserId(id), HttpStatus.OK);
	}
}
