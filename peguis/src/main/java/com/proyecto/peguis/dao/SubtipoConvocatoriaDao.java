package com.proyecto.peguis.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.proyecto.peguis.entities.SubtipoConvocatoria;
import com.proyecto.peguis.entities.TipoConvocatoria;
import com.proyecto.peguis.repositories.SubtipoConvocatoriaRepositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Component
public class SubtipoConvocatoriaDao implements SubtipoConvocatoriaRepositorio {
	
	@PersistenceContext
	EntityManager entityManager;
	CriteriaQuery<SubtipoConvocatoria> criteriaQuery;
	
	@Override
	public List<SubtipoConvocatoria> findConvocatoriasPorTipoConv(String tipoConv) {
		Map<String, String> filtroParsed = parseFiltro(tipoConv);

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		criteriaQuery = criteriaBuilder.createQuery(SubtipoConvocatoria.class);
		// SELECT * FROM CONVOCATORIA
		Root<SubtipoConvocatoria> root = criteriaQuery.from(SubtipoConvocatoria.class);
		Join<SubtipoConvocatoria, TipoConvocatoria> joinTipoSubtipoConv = root.join("tipoConvocatoria", JoinType.INNER);
		criteriaQuery.where(criteriaBuilder.equal(joinTipoSubtipoConv.get("tcoIde"), filtroParsed.get("tcoIde")));

		List<Predicate> predicates = new ArrayList<Predicate>();
		
		List<SubtipoConvocatoria> subtipoSconvocatoria = entityManager.createQuery(criteriaQuery).getResultList();

		return subtipoSconvocatoria;
	}

	@Override
	public List<SubtipoConvocatoria> findAll() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		criteriaQuery = criteriaBuilder.createQuery(SubtipoConvocatoria.class);
		Root<SubtipoConvocatoria> root = criteriaQuery.from(SubtipoConvocatoria.class);
		criteriaQuery.select(root);
		
		TypedQuery<SubtipoConvocatoria> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

//	@Override
//	public Optional<SubtipoConvocatoria> findById(String id) {
//		// TODO Auto-generated method stub
//		return Optional.empty();
//	}

	@Override
	public SubtipoConvocatoria save(SubtipoConvocatoria subtipoConvocatoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(SubtipoConvocatoria subtipoConvocatoria) {
		// TODO Auto-generated method stub
		
	}
	
	private Map<String, String> parseFiltro(String filtro) {
		Map<String, String> filtroParsed = new HashMap<String, String>();
		
		// contenido filtro: {"nombreVariableEnAngular":"key1:value1";"key2:value2"[;"key3:value3"]}
		filtro = filtro.substring(2); // quito la llave { y las comillas ". Queda nombreVariableEnAngular":"key1:value1";"key2:value2"[;"key3:value3"]}
		filtro = filtro.substring(0, filtro.length()-1); // Quito la llave } final. Queda "key1:value1";"key2:value2"[;"key3:value3"]
//		filtro = filtro.substring(filtro.indexOf("\"") + 2); // Quito nombreVariableEnAngular":. Queda "key1:value1";"key2:value2"[;"key3:value3"]}
		
		filtro = filtro.replace("\"", ""); // Quito todas las comillas "
		
		List<String> pares = Arrays.asList(filtro.split(";"));
		
		for(String par : pares) {
			List<String> claveValor = Arrays.asList(par.split(":"));
			
			String clave = claveValor.get(0);
			String valor = claveValor.get(1);
			
			filtroParsed.put(clave, valor);
			
//			System.out.println(clave + ": " + valor);
		}
		
//		pares.forEach(par -> {
//			String clave = par.substring(0, par.indexOf(":"));
//			String valor = par.substring(par.indexOf(":")+1);
//			filtroParsed.put(clave, valor);
//			System.out.println(clave + ": " + valor);
//		});
		
		
		return filtroParsed;
		
	}

}
