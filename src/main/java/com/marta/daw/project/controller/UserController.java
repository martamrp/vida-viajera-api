package com.marta.daw.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marta.daw.project.model.Login;
import com.marta.daw.project.model.User;
import com.marta.daw.project.model.UserRepository;

@RestController
@RequestMapping(path="user")
public class UserController {
	
	@Autowired
	UserRepository userRespository;

	@RequestMapping(path="login", method=RequestMethod.POST)
	public User login(@RequestBody @Valid Login login) {
		return userRespository.findByUsername(login.getUsername());
	}
	
}
