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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


/**
 * The persistent class for the expediente database table.
 * 
 */
@Entity
@Table(name="expediente")
@NamedQuery(name="Expediente.findAll", query="SELECT e FROM Expediente e")
public class Expediente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="exp_ide")
	private int expIde;

	@Column(name="exp_anyo")
	private String expAnyo;

	@Column(name="exp_numero")
	private String expNumero;

	@Column(name="exp_tipo")
	private String expTipo;

	//bi-directional many-to-one association to Convocatoria
	@OneToMany(mappedBy="expediente")
	@JsonBackReference
	private List<Convocatoria> convocatorias;

	//bi-directional many-to-one association to GrupoTramitacion
	@OneToMany(mappedBy="expediente")
	@JsonBackReference
	private List<GrupoTramitacion> grupoTramitacions;
	
	@OneToOne
	@JoinColumn(name="exp_uad_ide")
	private UnidadAdministrativa unidadAdministrativa;

	public Expediente() {
	}

	public int getExpIde() {
		return this.expIde;
	}

	public void setExpIde(int expIde) {
		this.expIde = expIde;
	}

	public String getExpAnyo() {
		return this.expAnyo;
	}

	public void setExpAnyo(String expAnyo) {
		this.expAnyo = expAnyo;
	}

	public String getExpNumero() {
		return this.expNumero;
	}

	public void setExpNumero(String expNumero) {
		this.expNumero = expNumero;
	}

	public String getExpTipo() {
		return this.expTipo;
	}

	public void setExpTipo(String expTipo) {
		this.expTipo = expTipo;
	}

	public List<Convocatoria> getConvocatorias() {
		return this.convocatorias;
	}

	public void setConvocatorias(List<Convocatoria> convocatorias) {
		this.convocatorias = convocatorias;
	}

	public Convocatoria addConvocatoria(Convocatoria convocatoria) {
		getConvocatorias().add(convocatoria);
		convocatoria.setExpediente(this);

		return convocatoria;
	}

	public Convocatoria removeConvocatoria(Convocatoria convocatoria) {
		getConvocatorias().remove(convocatoria);
		convocatoria.setExpediente(null);

		return convocatoria;
	}

	public List<GrupoTramitacion> getGrupoTramitacions() {
		return this.grupoTramitacions;
	}

	public void setGrupoTramitacions(List<GrupoTramitacion> grupoTramitacions) {
		this.grupoTramitacions = grupoTramitacions;
	}

	public UnidadAdministrativa getUnidadAdministrativa() {
		return unidadAdministrativa;
	}

	public void setUnidadAdministrativa(UnidadAdministrativa unidadAdministrativa) {
		this.unidadAdministrativa = unidadAdministrativa;
	}

	public GrupoTramitacion addGrupoTramitacion(GrupoTramitacion grupoTramitacion) {
		getGrupoTramitacions().add(grupoTramitacion);
		grupoTramitacion.setExpediente(this);

		return grupoTramitacion;
	}

	public GrupoTramitacion removeGrupoTramitacion(GrupoTramitacion grupoTramitacion) {
		getGrupoTramitacions().remove(grupoTramitacion);
		grupoTramitacion.setExpediente(null);

		return grupoTramitacion;
	}

}