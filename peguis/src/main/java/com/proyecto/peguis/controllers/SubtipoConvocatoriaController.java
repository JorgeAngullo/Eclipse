package com.proyecto.peguis.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyecto.peguis.entities.SubtipoConvocatoria;
import com.proyecto.peguis.repositories.SubtipoConvocatoriaRepositorio;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/subtiposConvocatoria"})
@CrossOrigin(origins = "http://localhost:4200")
public class SubtipoConvocatoriaController {
	@Autowired
	SubtipoConvocatoriaRepositorio repositorio;
	
	@GetMapping("/listar")
	@JsonIgnore
	public List<SubtipoConvocatoria> listar() {
		System.out.println("SubtipoConvocatoriaController -> Listar");
		List<SubtipoConvocatoria> subtiposConvocatoria = repositorio.findAll();
		System.out.println("Hay un total de: " + subtiposConvocatoria.size() + " subtipos de convocatoria");
		return subtiposConvocatoria;
	}
	
//	@GetMapping("/findById")
//	@JsonIgnore
//	public Optional<SubtipoConvocatoria> findById(String scoIde) {
//		System.out.println("findById: " + scoIde);
//		return repositorio.findById(scoIde);
//	}
	
	@PostMapping("/findPorTipoConv")
	@JsonIgnore
	public List<SubtipoConvocatoria> findPorTipoConv(@RequestBody String tcoIde) {
		System.out.println("findPorTipoConv: " + tcoIde);
		return repositorio.findConvocatoriasPorTipoConv(tcoIde);
	}
}
