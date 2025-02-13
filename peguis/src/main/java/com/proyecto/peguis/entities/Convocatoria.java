package com.proyecto.peguis.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



/**
 * The persistent class for the convocatoria database table.
 * 
 */
@Entity
@Table(name="convocatoria")
@NamedQuery(name="Convocatoria.findAll", query="SELECT c FROM Convocatoria c")
public class Convocatoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="con_ide")
	private int conIde;

	@Column(name="con_publicable")
	private String conPublicable;

	@Column(name="con_subtipo")
	private String conSubtipo;

	@Column(name="con_tipo")
	private String conTipo;

	@Column(name="con_titulo")
	private String conTitulo;
	
	@Column(name="con_fecha_creacion")
	private Date conFechaCreacion;
	
	@Column(name="con_estado")
	private String conEstado;
	
	@Column(name="con_ide_bdns")
	private Long conIdeBdns;

	//bi-directional many-to-one association to Expediente
	@ManyToOne
	@JoinColumn(name="con_exp_ide")
//	@JsonBackReference
	private Expediente expediente;

	//bi-directional many-to-one association to GrupoTramitacion
	@OneToMany(mappedBy="convocatoria")
//	@JsonBackReference
	private List<GrupoTramitacion> gruposTramitacion;
	
	@OneToOne
	@JoinColumn(name="con_esc_ide")
	private EstadoConvocatoria estadoConvocatoria;

	public Convocatoria() {
	}

	public int getConIde() {
		return this.conIde;
	}

	public void setConIde(int conIde) {
		this.conIde = conIde;
	}

	public String getConPublicable() {
		return this.conPublicable;
	}

	public void setConPublicable(String conPublicable) {
		this.conPublicable = conPublicable;
	}

	public String getConSubtipo() {
		return this.conSubtipo;
	}

	public void setConSubtipo(String conSubtipo) {
		this.conSubtipo = conSubtipo;
	}

	public String getConTipo() {
		return this.conTipo;
	}

	public void setConTipo(String conTipo) {
		this.conTipo = conTipo;
	}

	public String getConTitulo() {
		return this.conTitulo;
	}

	public void setConTitulo(String conTitulo) {
		this.conTitulo = conTitulo;
	}

	public Date getConFechaCreacion() {
		return conFechaCreacion;
	}

	public void setConFechaCreacion(Date conFechaCreacion) {
		this.conFechaCreacion = conFechaCreacion;
	}

	public String getConEstado() {
		return conEstado;
	}

	public void setConEstado(String conEstado) {
		this.conEstado = conEstado;
	}

	public Long getConIdeBdns() {
		return conIdeBdns;
	}

	public void setConIdeBdns(Long conIdeBdns) {
		this.conIdeBdns = conIdeBdns;
	}

	public Expediente getExpediente() {
		return this.expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public List<GrupoTramitacion> getGruposTramitacion() {
		return this.gruposTramitacion;
	}

	public void setGruposTramitacion(List<GrupoTramitacion> gruposTramitacion) {
		this.gruposTramitacion = gruposTramitacion;
	}

	public EstadoConvocatoria getEstadoConvocatoria() {
		return estadoConvocatoria;
	}

	public void setEstadoConvocatoria(EstadoConvocatoria estadoConvocatoria) {
		this.estadoConvocatoria = estadoConvocatoria;
	}

	public GrupoTramitacion addGrupoTramitacion(GrupoTramitacion grupoTramitacion) {
		getGruposTramitacion().add(grupoTramitacion);
		grupoTramitacion.setConvocatoria(this);

		return grupoTramitacion;
	}

	public GrupoTramitacion removeGrupoTramitacion(GrupoTramitacion grupoTramitacion) {
		getGruposTramitacion().remove(grupoTramitacion);
		grupoTramitacion.setConvocatoria(null);

		return grupoTramitacion;
	}

	@Override
	public String toString() {
		return "Convocatoria [conIde=" + conIde + ", conPublicable=" + conPublicable + ", conSubtipo=" + conSubtipo
				+ ", conTipo=" + conTipo + ", conTitulo=" + conTitulo + ", conFechaCreacion=" + conFechaCreacion + expediente + "]";
	}
}