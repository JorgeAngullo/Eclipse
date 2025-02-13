package com.proyecto.peguis.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.peguis.entities.TipoConvocatoria;

public interface TipoConvocatoriaService {
	List<TipoConvocatoria> listar();
	Optional<TipoConvocatoria> findById(String id);
	TipoConvocatoria add(TipoConvocatoria tipoConvocatoria);
	TipoConvocatoria edit(TipoConvocatoria tipoConvocatoria);
	void delete(TipoConvocatoria tipoConvocatoria);
}
