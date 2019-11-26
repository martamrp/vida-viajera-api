package com.marta.daw.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.marta.daw.project.model.Country;
import com.marta.daw.project.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;

	public List<Country> getCountries(){
		return countryRepository.findAllByOrderByNameAsc();
	};
	
	public ResponseEntity<?> getCountryByCode(String code){
		Optional<Country> country = countryRepository.findById(code);
		
		if(country == null) {
			return new ResponseEntity<>("El país no existe", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(country, HttpStatus.OK);
	};
}
