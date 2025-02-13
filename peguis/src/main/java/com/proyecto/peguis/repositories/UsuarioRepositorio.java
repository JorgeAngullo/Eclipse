package com.proyecto.peguis.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.peguis.entities.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {
	Optional<Usuario> findById(String id);
}
