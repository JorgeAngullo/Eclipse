package com.proyecto.peguis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.peguis.entities.EstadoConvocatoria;
import com.proyecto.peguis.repositories.EstadoConvocatoriaRepositorio;

@Service
public class EstadoConvocatoriaServiceImpl implements EstadoConvocatoriaService {
	@Autowired
	private EstadoConvocatoriaRepositorio repositorio;

	@Override
	public List<EstadoConvocatoria> listar() {
		return repositorio.findAll();
	}

	@Override
	public Optional<EstadoConvocatoria> findById(String id) {
		return repositorio.findById(id);
	}

	@Override
	public EstadoConvocatoria add(EstadoConvocatoria estadoConvocatoria) {
		return repositorio.save(estadoConvocatoria);
	}

	@Override
	public EstadoConvocatoria edit(EstadoConvocatoria estadoConvocatoria) {
		return repositorio.save(estadoConvocatoria);
	}

	@Override
	public void delete(EstadoConvocatoria estadoConvocatoria) {
		repositorio.delete(estadoConvocatoria);
	}
	
}