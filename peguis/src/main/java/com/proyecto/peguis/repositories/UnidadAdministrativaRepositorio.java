package com.proyecto.peguis.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.peguis.entities.UnidadAdministrativa;

public interface UnidadAdministrativaRepositorio extends JpaRepository<UnidadAdministrativa, String> {

	List<UnidadAdministrativa> findAll();
	Optional<UnidadAdministrativa> findById(String id);
	UnidadAdministrativa save(UnidadAdministrativa unidadAdministrativa);
	void delete(UnidadAdministrativa unidadAdministrativa);
}
