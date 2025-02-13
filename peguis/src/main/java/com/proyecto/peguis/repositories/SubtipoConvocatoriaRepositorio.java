package com.proyecto.peguis.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.peguis.entities.SubtipoConvocatoria;

@Repository
public interface SubtipoConvocatoriaRepositorio {
	List<SubtipoConvocatoria> findAll();
//	Optional<SubtipoConvocatoria> findOne(Long id);
//	Optional<SubtipoConvocatoria> findById(String id);
	SubtipoConvocatoria save(SubtipoConvocatoria subtipoConvocatoria);
	void delete(SubtipoConvocatoria subtipoConvocatoria);
	List<SubtipoConvocatoria> findConvocatoriasPorTipoConv(String tipoConv);	
}
