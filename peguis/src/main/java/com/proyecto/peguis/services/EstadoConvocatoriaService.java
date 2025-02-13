package com.proyecto.peguis.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.peguis.entities.EstadoConvocatoria;

public interface EstadoConvocatoriaService {
	List<EstadoConvocatoria> listar();
	Optional<EstadoConvocatoria> findById(String id);
	EstadoConvocatoria add(EstadoConvocatoria estadoConvocatoria);
	EstadoConvocatoria edit(EstadoConvocatoria estadoConvocatoria);
	void delete(EstadoConvocatoria estadoConvocatoria);
}
