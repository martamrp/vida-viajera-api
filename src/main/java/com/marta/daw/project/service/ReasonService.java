package com.marta.daw.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marta.daw.project.model.Reason;
import com.marta.daw.project.repository.ReasonRepository;

@Service
public class ReasonService {

	@Autowired
	ReasonRepository reasonRepository;
	
	public List<Reason> getReasons(){
		return reasonRepository.findAll();
	};	
}
