package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.Persona;

@Component
public interface PersonaJpaRepository extends JpaRepository<Persona, Integer>{

}
