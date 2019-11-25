package com.marta.daw.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marta.daw.project.model.Region;
import com.marta.daw.project.repository.RegionRepository;

@Service
public class RegionService {
	
	@Autowired
	RegionRepository regionRepository;

	public List<Region> getRegions(){
		return regionRepository.findAll();
	};
}
