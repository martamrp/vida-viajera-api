package com.marta.daw.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marta.daw.project.model.Country;
import com.marta.daw.project.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;

	public List<Country> getCountries(){
		return countryRepository.findAll();
	};
}
