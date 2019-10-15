package com.marta.daw.project.service;

import org.springframework.stereotype.Service;

import com.marta.daw.project.model.Info;

@Service
public class VidaViajeraService {
	
	public Info hello(String name) {
		Info info = new Info();
		info.setMessage("Hola "+ name + " desde el servicio");
		info.setTime(System.currentTimeMillis());
		return info;
	}

}
