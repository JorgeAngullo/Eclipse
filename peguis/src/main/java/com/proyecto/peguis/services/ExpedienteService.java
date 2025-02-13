package com.proyecto.peguis.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.peguis.entities.Expediente;

public interface ExpedienteService {
	List<Expediente> listar();
	Optional<Expediente> findById(String id);
	Expediente add(Expediente expediente);
	Expediente edit(Expediente expediente);
	void delete(Expediente expediente);
}
