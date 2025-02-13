package com.proyecto.peguis.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.peguis.entities.Usuario;
import com.proyecto.peguis.repositories.UsuarioRepositorio;

public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioRepositorio repositorio;

	@Override
	public boolean login(String user, String password) {
		Optional<Usuario> usuarioOptional = repositorio.findById(user);
		
		return usuarioOptional != null && password.equals((usuarioOptional.get()).getContraseña());		
	}

}
