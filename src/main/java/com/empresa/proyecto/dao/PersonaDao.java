package com.empresa.proyecto.dao;

import java.util.List;

import com.empresa.proyecto.model.Persona;

public interface PersonaDao {

	public Persona obtenerPersona(String dni);
	
	public List<Persona> listarPersona();
	
}
