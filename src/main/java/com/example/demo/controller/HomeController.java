package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaJpaRepository;

@Controller
public class HomeController {

	@Autowired
	PersonaJpaRepository personaRepo;
	
	@RequestMapping(value = "/")
	@ResponseBody
	public String index() {
		return "Hola demo";
	}
	
	@RequestMapping(value = "/persona")
	public String persona(Model model) {
		Persona p = new Persona();
		p.setId(0);
		p.setNombre("NERIO BAEZ");
		
		
		List<Persona>  lp = personaRepo.findAll();
		lp.add(p);
		model.addAttribute("lista",lp);
		return "persona";
	}
	
	@GetMapping(value = "/all")
	public List<Persona> all() {
		return personaRepo.findAll();
	}
	
	@PostMapping(value = "/registrar")
	public String registrar(String nombre, Model model) {
		Persona p = new Persona();
		p.setNombre(nombre);
		
		
		personaRepo.save(p);
		
		return "redirect:/persona";
	}
	
	
	@GetMapping(value = "/eliminar")
	public String registrar(Integer id) {
		Persona p = new Persona();
		p.setId(id);
		
		
		personaRepo.delete(p);
		
		return "redirect:/persona";
	}
	
	@PostMapping(value = "/regpersona")
	@ResponseBody
	public Persona regPersona(@RequestBody Persona p) {
		personaRepo.save(p);
		
		return p;
	}
	
	@PostMapping(value = "/elimpersona")
	@ResponseBody
	public Integer elimPersona(@RequestBody Persona p) {
		personaRepo.delete(p);
		
		return 1;
	}
	
	@PostMapping(value = "/cargarpersona")
	@ResponseBody
	public List<Persona> cargarPersona() {
		return personaRepo.findAll();
	}
}
