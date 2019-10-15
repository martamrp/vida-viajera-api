package com.marta.daw.project.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marta.daw.project.model.Reason;

@RestController
public class ReasonController {

	@RequestMapping(value="reason", method=RequestMethod.GET)
	public Reason getReasons() {
		return new Reason();
	}
	
	@RequestMapping(value="reason/{id}", method=RequestMethod.GET)
	public Reason getReason(@PathVariable int id) {
		return new Reason();
	}
	
	@RequestMapping(value="reason2", method=RequestMethod.GET)
	public Reason getReason2(@RequestParam int id) {
		return new Reason();
	}
}
