package com.marta.daw.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marta.daw.project.model.Reason;
import com.marta.daw.project.service.ReasonService;

@CrossOrigin
@RestController
@RequestMapping(path="reasons")
public class ReasonsController {
	
	@Autowired
	ReasonService reasonService;

	@RequestMapping(method=RequestMethod.GET)
	public List<Reason> showReasons(){
		return reasonService.getReasons();
	};	 
}
