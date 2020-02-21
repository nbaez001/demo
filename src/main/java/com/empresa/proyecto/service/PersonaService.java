package com.empresa.proyecto.service;

import java.util.List;

import com.empresa.proyecto.model.Persona;

public interface PersonaService {

	public Persona obtenerPersona(String dni);

	public List<Persona> listarPersona();
}
