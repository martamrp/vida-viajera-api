package com.marta.daw.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marta.daw.project.model.Country;
import com.marta.daw.project.service.CountryService;

@CrossOrigin
@RestController
@RequestMapping(path="countries")
public class CountriesController {
	
	@Autowired
	CountryService countryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Country> getCountries(){
		return countryService.getCountries();
	};	
}
