package com.proyecto.peguis.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyecto.peguis.entities.Convocatoria;
import com.proyecto.peguis.entities.TipoConvocatoria;
import com.proyecto.peguis.repositories.TipoConvocatoriaRepositorio;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/tiposConvocatoria"})
@CrossOrigin(origins = "http://localhost:4200")
public class TipoConvocatoriaController {
	@Autowired
	TipoConvocatoriaRepositorio repositorio;
	
	@GetMapping("/listar")
	@JsonIgnore
	public List<TipoConvocatoria> listar() {
		System.out.println("TipoConvocatoriaController -> Listar");
		List<TipoConvocatoria> tiposConvocatoria = repositorio.findAll();
		System.out.println("Hay un total de: " + tiposConvocatoria.size() + " tipos de convocatoria");
		return tiposConvocatoria;
	}
	
	@GetMapping("/findById")
	@JsonIgnore
	public Optional<TipoConvocatoria> findById(String tcoIde) {
		System.out.println("findById: " + tcoIde);
		return repositorio.findById(tcoIde);
	}	
}
