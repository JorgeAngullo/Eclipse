package com.proyecto.peguis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.peguis.entities.UnidadAdministrativa;
import com.proyecto.peguis.repositories.UnidadAdministrativaRepositorio;

@Service
public class UnidadAdministrativaServiceImpl implements UnidadAdministrativaService {
	@Autowired
	private UnidadAdministrativaRepositorio repositorio;

	@Override
	public List<UnidadAdministrativa> listar() {
		return repositorio.findAll();
	}

	@Override
	public Optional<UnidadAdministrativa> findById(String id) {
		return repositorio.findById(id);
	}

	@Override
	public UnidadAdministrativa add(UnidadAdministrativa UnidadAdministrativa) {
		return repositorio.save(UnidadAdministrativa);
	}

	@Override
	public UnidadAdministrativa edit(UnidadAdministrativa UnidadAdministrativa) {
		return repositorio.save(UnidadAdministrativa);
	}

	@Override
	public void delete(UnidadAdministrativa UnidadAdministrativa) {
		repositorio.delete(UnidadAdministrativa);
	}
	
}