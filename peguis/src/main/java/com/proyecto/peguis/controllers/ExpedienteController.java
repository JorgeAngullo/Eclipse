package com.proyecto.peguis.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.peguis.entities.Expediente;
import com.proyecto.peguis.repositories.ExpedienteRepositorio;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/expedientes"})
@CrossOrigin(origins = "http://localhost:4200")
public class ExpedienteController {
	@Autowired
	ExpedienteRepositorio repositorio;
	
	@GetMapping("/listar")
//	@JsonIgnore
	public List<Expediente> listar() {
		System.out.println("ExpedienteController -> Listar");
		List<Expediente> expedientes = repositorio.findAll();
		System.out.println("Hay un total de: " + expedientes.size() + " expedientes");
		return expedientes;
	}
	
	@GetMapping("/findById")
//	@JsonIgnore
	public Optional<Expediente> findById(String expIde) {
		System.out.println("ExpedienteController -> findById: " + expIde);
		return repositorio.findById(expIde);
	}
	
//	@GetMapping("/filtrar")
//	@JsonIgnore
//	public List<Expediente> filtrar(Map<Object, Object> filtro) {
//		filtro.forEach((key, value) -> System.out.println(value));
//		return repositorio.buscarPorCriterios(filtro);
//	}
	
//	@PostMapping("/filtrar")
//	@JsonIgnore
//	public List<Expediente> filtrar(@RequestBody Map<String, Object> filtro) {
//	public List<Expediente> filtrar(@RequestBody String filtro) {
//		System.out.println("ExpedienteController -> filtrar");
//		return repositorio.buscarPorCriterios(filtro);
//	}
}
