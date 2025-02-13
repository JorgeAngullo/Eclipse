package com.proyecto.peguis.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.peguis.entities.EstadoConvocatoria;

public interface EstadoConvocatoriaRepositorio extends JpaRepository<EstadoConvocatoria, String> {

	List<EstadoConvocatoria> findAll();
	Optional<EstadoConvocatoria> findById(String id);
	EstadoConvocatoria save(EstadoConvocatoria estadoConvocatoria);
	void delete(EstadoConvocatoria estadoConvocatoria);
}
