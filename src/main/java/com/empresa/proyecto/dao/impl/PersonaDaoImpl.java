package com.empresa.proyecto.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.empresa.proyecto.dao.PersonaDao;
import com.empresa.proyecto.model.Persona;
import com.empresa.proyecto.model.mapper.PersonaRowMapper;

@Repository
public class PersonaDaoImpl implements PersonaDao {

	@Autowired
	DataSource dataSource;
	
	@Override
	public Persona obtenerPersona(String dni) {
		Persona pe = new Persona();
		pe.setId(1);
		pe.setDni("47794103");
		pe.setNombre("cesar");
		pe.setApellidoPaterno("baez");
		pe.setApellidoMaterno("delgado");
		return pe;
	}

	@Override
	public List<Persona> listarPersona() {
		List<Persona> lista = new ArrayList<>();
		Map<String, Object> out = new HashMap<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withSchemaName("CESAR")
					.withCatalogName("PCK_APP")
					.withProcedureName("SP_LISTAR_PERSONA")
					.returningResultSet("AC_LISTA", new PersonaRowMapper());

			out = simpleJdbcCall.execute();

			lista = (List<Persona>) out.get("AC_LISTA");
		} catch (Exception e) {
			System.out.println("Error al listar : "+ e.getMessage());
		}
		
		return lista;
//		List<Persona> listar = new ArrayList<>();
//
//		for (int i = 0; i < 20; i++) {
//			Persona pe = new Persona();
//			pe.setId(1);
//			pe.setDni("47794103");
//			pe.setNombre("cesar");
//			pe.setApellidoPaterno("baez");
//			pe.setApellidoMaterno("delgado");
//
//			listar.add(pe);
//
//		}
//
//		return listar;

	}

}
