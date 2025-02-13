package com.proyecto.peguis.entities;

import java.io.Serializable;

import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


/**
 * The persistent class for the grupo_tramitacion database table.
 * 
 */
@Entity
@Table(name="grupo_tramitacion")
@NamedQuery(name="GrupoTramitacion.findAll", query="SELECT g FROM GrupoTramitacion g")
public class GrupoTramitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="gtr_ide")
	private int gtrIde;

	@Column(name="gtr_tipo")
	private String gtrTipo;

	//bi-directional many-to-one association to Convocatoria
	@ManyToOne
	@JoinColumn(name="gtr_con_ide")
//	@JsonBackReference
	@JsonIgnore
	private Convocatoria convocatoria;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="gtr_exp_ide")
	@JsonBackReference
	private Expediente expediente;

//	//bi-directional many-to-one association to GrupoTramitacionSolicitud
//	@ManyToOne
//	@JoinColumn(name="gtr_ide"/*, referencedColumnName="gts_gtr_ide"*/)
//	@JsonBackReference
//	private GrupoTramitacionSolicitud grupoTramitacionSolicitud;

	public GrupoTramitacion() {
	}

	public int getGtrIde() {
		return this.gtrIde;
	}

	public void setGtrIde(int gtrIde) {
		this.gtrIde = gtrIde;
	}

	public String getGtrTipo() {
		return this.gtrTipo;
	}

	public void setGtrTipo(String gtrTipo) {
		this.gtrTipo = gtrTipo;
	}

	public Convocatoria getConvocatoria() {
		return this.convocatoria;
	}

	public void setConvocatoria(Convocatoria convocatoria) {
		this.convocatoria = convocatoria;
	}

	public Expediente getExpediente() {
		return this.expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

//	public GrupoTrami 

}