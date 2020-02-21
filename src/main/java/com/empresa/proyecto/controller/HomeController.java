package com.empresa.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.proyecto.model.Persona;
import com.empresa.proyecto.service.PersonaService;

@Controller
public class HomeController {
	
	@Autowired
	PersonaService peService;
	
	@PostMapping("persona")
	@ResponseBody
	public Persona obtenerPersona(@RequestBody String dni) {
		return peService.obtenerPersona(dni);
	}

	@PostMapping("listarPersona")
	@ResponseBody
	public List<Persona> listarPersona() {
		return peService.listarPersona();
	}
	
}
