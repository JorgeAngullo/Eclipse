package com.proyecto.peguis.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.peguis.entities.Expediente;

public interface ExpedienteRepositorio extends JpaRepository<Expediente, String> {

	List<Expediente> findAll();
	Optional<Expediente> findById(String id);
	Expediente save(Expediente expediente);
	void delete(Expediente expediente);
}
