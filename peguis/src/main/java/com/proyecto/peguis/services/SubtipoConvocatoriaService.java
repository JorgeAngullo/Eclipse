package com.proyecto.peguis.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.peguis.entities.SubtipoConvocatoria;

public interface SubtipoConvocatoriaService {
	List<SubtipoConvocatoria> listar();
	List<SubtipoConvocatoria> findById(String id);
	SubtipoConvocatoria add(SubtipoConvocatoria subtipoConvocatoria);
	SubtipoConvocatoria edit(SubtipoConvocatoria subtipoConvocatoria);
	void delete(SubtipoConvocatoria subtipoConvocatoria);
}
