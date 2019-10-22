package com.marta.daw.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marta.daw.project.model.Reason;
import com.marta.daw.project.model.ReasonRepository;

@RestController
@RequestMapping(path="reason")
public class ReasonController {
	
	@Autowired
	ReasonRepository reasonRepository;

	@RequestMapping(method=RequestMethod.GET)
	public List<Reason> getReasons(){
		return reasonRepository.findAll();
	};	
}
