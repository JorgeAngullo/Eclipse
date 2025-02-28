package com.proyecto.peguis.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyecto.peguis.entities.Usuario;
import com.proyecto.peguis.repositories.UsuarioRepositorio;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/usuarios"})
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	@Autowired
	UsuarioRepositorio repositorio;
	
	@GetMapping("/findById")
	@JsonIgnore
	public Optional<Usuario> findById(String usuario) {
		System.out.println("UsuarioController -> findById: " + usuario);
		return repositorio.findById(usuario);
	}
}
