package com.marta.daw.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marta.daw.project.model.Login;
import com.marta.daw.project.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(path = "users")
public class UsersController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(path = "login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody @Valid Login login) {
		return userService.login(login);
	}

	@RequestMapping(path = "{id}/trips", method = RequestMethod.GET)
	public ResponseEntity<?> getTripsByUserId(@PathVariable int id) {
		return userService.getTripsByUserId(id);
	}
	
	@RequestMapping(path = "{id}/stats", method = RequestMethod.GET)
	public ResponseEntity<?> getStatsByUserId(@PathVariable int id){
		return userService.getStatsByUserId(id);
	}
}
