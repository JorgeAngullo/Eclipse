package com.proyecto.peguis.repositories;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.peguis.dao.ConvocatoriaDao;
import com.proyecto.peguis.entities.Convocatoria;

@Repository
public interface ConvocatoriaRepositorio {
	List<Convocatoria> findAll();
//	Optional<Convocatoria> findOne(Long id);
	Optional<Convocatoria> findById(Long id);
	Convocatoria save(Convocatoria convocatoria);
	void delete(Convocatoria convocatoria);
//	List<Convocatoria> buscarPorCriterios(Map<String, Object> filtro);
	List<Convocatoria> buscarPorCriterios(String filtro);
}
