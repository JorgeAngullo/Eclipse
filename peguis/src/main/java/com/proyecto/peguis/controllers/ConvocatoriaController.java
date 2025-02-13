package com.proyecto.peguis.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyecto.peguis.entities.Convocatoria;
import com.proyecto.peguis.repositories.ConvocatoriaRepositorio;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping({"/convocatorias"})
@CrossOrigin(origins = "http://localhost:4200")
public class ConvocatoriaController {
	@Autowired
	ConvocatoriaRepositorio repositorio;
	
	@GetMapping("/convocatorias")
//	@JsonIgnore
	public List<Convocatoria> listar() {
		System.out.println("ConvocatoriaController -> Listar");
		List<Convocatoria> convocatorias = repositorio.findAll();
		System.out.println("Hay un total de: " + convocatorias.size() + " convocatorias");
		return convocatorias;
	}
	
	@GetMapping("/convocatorias/{id}")
//	@JsonIgnore
	public Optional<Convocatoria> findById(@PathVariable("id") Long conIde) {
		System.out.println("ConvocatoriaController -> findById: " + conIde);
		return repositorio.findById(conIde);
	}
	
//	@GetMapping("/filtrar")
//	@JsonIgnore
//	public List<Convocatoria> filtrar(Map<Object, Object> filtro) {
//		filtro.forEach((key, value) -> System.out.println(value));
//		return repositorio.buscarPorCriterios(filtro);
//	}
	
	@PostMapping("/filtrar")
	@JsonIgnore
//	public List<Convocatoria> filtrar(@RequestBody Map<String, Object> filtro) {
	public List<Convocatoria> filtrar(@RequestBody String filtro) {
		System.out.println("ConvocatoriaController -> filtrar");
		return repositorio.buscarPorCriterios(filtro);
	}
}
