package com.empresa.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.proyecto.dao.PersonaDao;
import com.empresa.proyecto.model.Persona;
import com.empresa.proyecto.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	PersonaDao peDao;

	@Override
	public Persona obtenerPersona(String dni) {
		return peDao.obtenerPersona(dni);
	}

	@Override
	public List<Persona> listarPersona() {
		
		return peDao.listarPersona();
	}

}
