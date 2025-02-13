package com.proyecto.peguis.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyecto.peguis.entities.UnidadAdministrativa;
import com.proyecto.peguis.repositories.UnidadAdministrativaRepositorio;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/unidadesAdministrativas"})
@CrossOrigin(origins = "http://localhost:4200")
public class UnidadAdministrativaController {
	@Autowired
	UnidadAdministrativaRepositorio repositorio;
	
	@GetMapping("/listar")
	@JsonIgnore
	public List<UnidadAdministrativa> listar() {
		System.out.println("UnidadAdministrativaController -> Listar");
		List<UnidadAdministrativa> unidadesAdministrativas = repositorio.findAll();
		System.out.println("Hay un total de: " + unidadesAdministrativas.size() + " unidades administrativas");
		return unidadesAdministrativas;
	}
	
	@GetMapping("/findById")
	@JsonIgnore
	public Optional<UnidadAdministrativa> findById(String escIde) {
		System.out.println("findById: " + escIde);
		return repositorio.findById(escIde);
	}	
}
