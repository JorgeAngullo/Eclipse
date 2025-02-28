package com.proyecto.peguis.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.peguis.entities.Convocatoria;
import com.proyecto.peguis.entities.EstadoConvocatoria;
import com.proyecto.peguis.entities.Expediente;
import com.proyecto.peguis.entities.UnidadAdministrativa;
import com.proyecto.peguis.repositories.ConvocatoriaRepositorio;
import com.proyecto.peguis.repositories.EstadoConvocatoriaRepositorio;
import com.proyecto.peguis.repositories.UnidadAdministrativaRepositorio;

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
public class ConvocatoriaDao implements ConvocatoriaRepositorio {
	
	@PersistenceContext
	EntityManager entityManager;
	CriteriaQuery<Convocatoria> criteriaQuery;
	
	@Autowired
	EstadoConvocatoriaRepositorio estadoConvocatoriaRepositorio;
	
	@Autowired
	UnidadAdministrativaRepositorio unidadAdministrativaRepositorio;
	
	@Override
	public List<Convocatoria> buscarPorCriterios(String filtro) {
		
		Map<String, String> filtroParsed = parseFiltro(filtro);
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		criteriaQuery = criteriaBuilder.createQuery(Convocatoria.class);
		// SELECT * FROM CONVOCATORIA
		Root<Convocatoria> root = criteriaQuery.from(Convocatoria.class);
		Join<Convocatoria, Expediente> joinExp = root.join("expediente", JoinType.INNER);
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		for(String s : filtroParsed.keySet()) {
			if (s.startsWith("exp")) {
				
				if (s.startsWith("expUnidadAdministrativa")) {
					Optional<UnidadAdministrativa> optionalUnidadAdministrativa = unidadAdministrativaRepositorio.findById(filtroParsed.get(s));
					
					if (optionalUnidadAdministrativa != null) {
						UnidadAdministrativa unidadAdministratva = optionalUnidadAdministrativa.get();
						predicates.add(criteriaBuilder.equal(joinExp.get("unidadAdministrativa"), unidadAdministratva));
					}
				} else {					
					predicates.add(criteriaBuilder.equal(joinExp.get(s), filtroParsed.get(s)));
				}
			}
			
			if (s.startsWith("con")) {
				if (s.equals("conFechaCreacionDesde")) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					Date fechaCreacionDesde = null;
					try {
						fechaCreacionDesde = sdf.parse(filtroParsed.get(s));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Predicate p = criteriaBuilder.greaterThanOrEqualTo(root.get("conFechaCreacion"), fechaCreacionDesde);
					predicates.add(p);
				} else if (s.equals("conFechaCreacionHasta")) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					Date fechaCreacionHasta = null;
					try {
						fechaCreacionHasta = sdf.parse(filtroParsed.get(s));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Predicate p = criteriaBuilder.lessThanOrEqualTo(root.get("conFechaCreacion"), fechaCreacionHasta);
					predicates.add(p);
				} else if (s.equals("conFechaModificacionDesde")) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					Date fechaModificacionDesde = null;
					try {
						fechaModificacionDesde = sdf.parse(filtroParsed.get(s));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Predicate p = criteriaBuilder.greaterThanOrEqualTo(root.get("conFechaCreacion"), fechaModificacionDesde);
					predicates.add(p);
				} else if (s.equals("conFechaModificacionHasta")) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					Date fechaModificacionHasta = null;
					try {
						fechaModificacionHasta = sdf.parse(filtroParsed.get(s));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Predicate p = criteriaBuilder.lessThanOrEqualTo(root.get("conFechaCreacion"), fechaModificacionHasta);
					predicates.add(p);
				} else if (s.equals("conEstado")) {
					Optional<EstadoConvocatoria> optionalEstadoConv = estadoConvocatoriaRepositorio.findById(filtroParsed.get(s));
					
					if (optionalEstadoConv != null) {
						EstadoConvocatoria estadoConv = optionalEstadoConv.get();
						predicates.add(criteriaBuilder.equal(root.get("estadoConvocatoria"), estadoConv));
					}
//				} else if (s.equals("conTipo")) {
//					
//				} else if (s.equals("conSubtipo")) {
//					
				} else {
					predicates.add(criteriaBuilder.equal(root.get(s), filtroParsed.get(s)));
				}
			}
		}
		
		Predicate predFinal = criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		criteriaQuery.where(predFinal);
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("conIde")));
		
//		TypedQuery<Convocatoria> query = entityManager.createQuery(criteriaQuery).setFirstResult(3).setMaxResults(5);
		TypedQuery<Convocatoria> query = entityManager.createQuery(criteriaQuery);
		List<Convocatoria> convs = query.getResultList();
		
		convs.forEach(conv -> {System.out.println(conv);});
//		return query.getResultList();
		return convs;
	}
//
//	@Override
//	public List<Convocatoria> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Optional<Convocatoria> findById(Long id) {
//		// TODO Auto-generated method stub
//		return Optional.empty();
//	}
//
//	@Override
//	public Convocatoria save(Convocatoria convocatoria) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void delete(Convocatoria convocatoria) {
//		// TODO Auto-generated method stub
//		
//	}
//
	@Override
	public List<Convocatoria> findAll() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		criteriaQuery = criteriaBuilder.createQuery(Convocatoria.class);
		Root<Convocatoria> root = criteriaQuery.from(Convocatoria.class);
		criteriaQuery.select(root);
		
		TypedQuery<Convocatoria> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public Optional<Convocatoria> findById(Long id) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		criteriaQuery = criteriaBuilder.createQuery(Convocatoria.class);
		// SELECT * FROM CONVOCATORIA
		Root<Convocatoria> root = criteriaQuery.from(Convocatoria.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("conIde"), id));
		List<Convocatoria> convs = entityManager.createQuery(criteriaQuery).getResultList();
		System.out.println("Convocatoria con id: " + id + (convs.size() > 0 ? convs.get(0) : " -> No existe"));
		
		return convs.size() > 0 ? Optional.of(convs.get(0)) : Optional.empty();
	}

	@Override
	public Convocatoria save(Convocatoria convocatoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Convocatoria convocatoria) {
		// TODO Auto-generated method stub
		
	}
	
	private Map<String, String> parseFiltro(String filtro) {
		Map<String, String> filtroParsed = new HashMap<String, String>();
		
		// contenido filtro: {"nombreVariableEnAngular":"key1:value1";"key2:value2"[;"key3:value3"]}
		filtro = filtro.substring(2); // quito la llave { y las comillas ". Queda nombreVariableEnAngular":"key1:value1";"key2:value2"[;"key3:value3"]}
		filtro = filtro.substring(filtro.indexOf("\"") + 2); // Quito nombreVariableEnAngular":. Queda "key1:value1";"key2:value2"[;"key3:value3"]}
		filtro = filtro.substring(0, filtro.length()-1); // Quito la llave } final. Queda "key1:value1";"key2:value2"[;"key3:value3"]
		
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
