package com.proyecto.peguis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.peguis.entities.SubtipoConvocatoria;
import com.proyecto.peguis.repositories.SubtipoConvocatoriaRepositorio;

@Service
public class SubtipoConvocatoriaServiceImpl implements SubtipoConvocatoriaService {
	@Autowired
	private SubtipoConvocatoriaRepositorio repositorio;

	@Override
	public List<SubtipoConvocatoria> listar() {
		return repositorio.findAll();
	}

//	@Override
//	public Optional<SubtipoConvocatoria> findById(String id) {
//		return repositorio.findById(id);
//	}

	@Override
	public SubtipoConvocatoria add(SubtipoConvocatoria subtipoConvocatoria) {
		return repositorio.save(subtipoConvocatoria);
	}

	@Override
	public SubtipoConvocatoria edit(SubtipoConvocatoria subtipoConvocatoria) {
		return repositorio.save(subtipoConvocatoria);
	}

	@Override
	public void delete(SubtipoConvocatoria subtipoConvocatoria) {
		repositorio.delete(subtipoConvocatoria);
	}

	@Override
	public List<SubtipoConvocatoria> findById(String id) {
		return repositorio.findConvocatoriasPorTipoConv(id);
	}
}
