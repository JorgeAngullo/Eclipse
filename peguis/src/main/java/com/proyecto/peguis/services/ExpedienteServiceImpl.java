package com.proyecto.peguis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.peguis.entities.Expediente;
import com.proyecto.peguis.repositories.ExpedienteRepositorio;

@Service
public class ExpedienteServiceImpl implements ExpedienteService {
	@Autowired
	private ExpedienteRepositorio repositorio;

	@Override
	public List<Expediente> listar() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Expediente> findById(String id) {
		return repositorio.findById(id);
	}

	@Override
	public Expediente add(Expediente Expediente) {
		return repositorio.save(Expediente);
	}

	@Override
	public Expediente edit(Expediente Expediente) {
		return repositorio.save(Expediente);
	}

	@Override
	public void delete(Expediente Expediente) {
		repositorio.delete(Expediente);
	}
	
}