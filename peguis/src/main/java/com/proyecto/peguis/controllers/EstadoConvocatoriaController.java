package com.proyecto.peguis.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyecto.peguis.entities.EstadoConvocatoria;
import com.proyecto.peguis.repositories.EstadoConvocatoriaRepositorio;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/estadosConvocatoria"})
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoConvocatoriaController {
	@Autowired
	EstadoConvocatoriaRepositorio repositorio;
	
	@GetMapping("/listar")
	@JsonIgnore
	public List<EstadoConvocatoria> listar() {
		System.out.println("EstadoConvocatoriaController -> Listar");
		List<EstadoConvocatoria> estadosConvocatoria = repositorio.findAll();
		System.out.println("Hay un total de: " + estadosConvocatoria.size() + " estados de convocatoria");
		return estadosConvocatoria;
	}
	
	@GetMapping("/findById")
	@JsonIgnore
	public Optional<EstadoConvocatoria> findById(String escIde) {
		System.out.println("findById: " + escIde);
		return repositorio.findById(escIde);
	}	
}
