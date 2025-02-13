package com.proyecto.peguis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.peguis.entities.TipoConvocatoria;
import com.proyecto.peguis.repositories.TipoConvocatoriaRepositorio;

@Service
public class TipoConvocatoriaServiceImpl implements TipoConvocatoriaService {
	@Autowired
	private TipoConvocatoriaRepositorio repositorio;

	@Override
	public List<TipoConvocatoria> listar() {
		return repositorio.findAll();
	}

	@Override
	public Optional<TipoConvocatoria> findById(String id) {
		return repositorio.findById(id);
	}

	@Override
	public TipoConvocatoria add(TipoConvocatoria tipoConvocatoria) {
		return repositorio.save(tipoConvocatoria);
	}

	@Override
	public TipoConvocatoria edit(TipoConvocatoria tipoConvocatoria) {
		return repositorio.save(tipoConvocatoria);
	}

	@Override
	public void delete(TipoConvocatoria tipoConvocatoria) {
		repositorio.delete(tipoConvocatoria);
	}
	
}
