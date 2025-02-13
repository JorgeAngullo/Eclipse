package com.proyecto.peguis.entities;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the grupo_tramitacion_solicitud database table.
 * 
 */
@Entity
@Table(name="grupo_tramitacion_solicitud")
@NamedQuery(name="GrupoTramitacionSolicitud.findAll", query="SELECT g FROM GrupoTramitacionSolicitud g")
public class GrupoTramitacionSolicitud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="gts_ide")
	private int gtsIde;

//	//bi-directional many-to-one association to GrupoTramitacion
//	@OneToMany(mappedBy="grupoTramitacionSolicitud")
//	@JsonBackReference
//	private List<GrupoTramitacion> gruposTramitacion;

	//bi-directional many-to-one association to Solicitud
	@OneToMany(mappedBy="grupoTramitacionSolicitud")
	@JsonBackReference
	private List<Solicitud> solicitudes;
	
	@Column
	private Long gtsSolIde;

	public GrupoTramitacionSolicitud() {
	}

	public int getGtsIde() {
		return this.gtsIde;
	}

	public void setGtsIde(int gtsIde) {
		this.gtsIde = gtsIde;
	}

//	public List<GrupoTramitacion> getGruposTramitacion() {
//		return this.gruposTramitacion;
//	}
//
//	public void setGruposTramitacion(List<GrupoTramitacion> gruposTramitacion) {
//		this.gruposTramitacion = gruposTramitacion;
//	}

//	public GrupoTramitacion addGrupoTramitacion(GrupoTramitacion grupoTramitacion) {
//		getGruposTramitacion().add(grupoTramitacion);
//		grupoTramitacion.setGrupoTramitacionSolicitud(this);
//
//		return grupoTramitacion;
//	}
//
//	public GrupoTramitacion removeGrupoTramitacion(GrupoTramitacion grupoTramitacion) {
//		getGruposTramitacion().remove(grupoTramitacion);
//		grupoTramitacion.setGrupoTramitacionSolicitud(null);
//
//		return grupoTramitacion;
//	}

	public List<Solicitud> getSolicitudes() {
		return this.solicitudes;
	}

	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public Solicitud addSolicitud(Solicitud solicitud) {
		getSolicitudes().add(solicitud);
		solicitud.setGrupoTramitacionSolicitud(this);

		return solicitud;
	}

	public Solicitud removeSolicitud(Solicitud solicitud) {
		getSolicitudes().remove(solicitud);
		solicitud.setGrupoTramitacionSolicitud(null);

		return solicitud;
	}

	public Long getGtsSolIde() {
		return gtsSolIde;
	}

	public void setGtsSolIde(Long gtsSolIde) {
		this.gtsSolIde = gtsSolIde;
	}

}