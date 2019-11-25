package com.marta.daw.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marta.daw.project.model.Region;
import com.marta.daw.project.service.RegionService;

@CrossOrigin
@RestController
@RequestMapping(path="regions")
public class RegionsController {

	@Autowired
	RegionService regionService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Region> getRegions(){
		return regionService.getRegions();
	};
}
