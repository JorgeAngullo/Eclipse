package com.proyecto.peguis.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.peguis.entities.UnidadAdministrativa;

public interface UnidadAdministrativaService {
	List<UnidadAdministrativa> listar();
	Optional<UnidadAdministrativa> findById(String id);
	UnidadAdministrativa add(UnidadAdministrativa unidadAdministrativa);
	UnidadAdministrativa edit(UnidadAdministrativa unidadAdministrativa);
	void delete(UnidadAdministrativa unidadAdministrativa);
}
