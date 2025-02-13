package com.proyecto.peguis.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.peguis.entities.TipoConvocatoria;

@Repository
public interface TipoConvocatoriaRepositorio extends JpaRepository<TipoConvocatoria, String> {
	List<TipoConvocatoria> findAll();
//	Optional<Convocatoria> findOne(Long id);
	Optional<TipoConvocatoria> findById(String id);
	TipoConvocatoria save(TipoConvocatoria tipoConvocatoria);
	void delete(TipoConvocatoria tipoConvocatoria);
	
}
