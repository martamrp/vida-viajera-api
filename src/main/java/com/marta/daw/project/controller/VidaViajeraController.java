package com.marta.daw.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marta.daw.project.model.BodyExample;
import com.marta.daw.project.model.Info;
import com.marta.daw.project.service.VidaViajeraService;

@RestController
public class VidaViajeraController {
	
	@Autowired
	private VidaViajeraService service;
	
	@RequestMapping(value="hello", method = RequestMethod.GET)
	public Info saludo(@RequestParam("nombre") String name) {
		return service.hello(name);
	}
	
	//@PostMapping("sendBody")
	@RequestMapping(value="sendBody", method = RequestMethod.POST)
	public Info requestBodyExample(@RequestBody @Valid BodyExample bodyExample) {
		return service.hello(bodyExample.getName());
	}
}
