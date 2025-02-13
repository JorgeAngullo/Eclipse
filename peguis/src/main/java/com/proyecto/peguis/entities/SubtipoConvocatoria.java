package com.proyecto.peguis.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the subtipo_convocatoria database table.
 * 
 */
@Entity
@Table(name="subtipo_convocatoria")
@NamedQuery(name="SubtipoConvocatoria.findAll", query="SELECT s FROM SubtipoConvocatoria s")
public class SubtipoConvocatoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sco_tco_ide")
	private String scoTcoIde;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sco_ide")
	private String scoIde;

	@Column(name="sco_des")
	private String scoDes;
	
	@ManyToOne
	@JoinColumn(name="sco_tco_ide")
	private TipoConvocatoria tipoConvocatoria;

	public SubtipoConvocatoria() {
	}
	
	public String getScoTcoIde() {
		return this.scoTcoIde;
	}

	public void setScoTcoIde(String scoTcoIde) {
		this.scoTcoIde = scoTcoIde;
	}

	public String getScoIde() {
		return this.scoIde;
	}

	public void setScoIde(String scoIde) {
		this.scoIde = scoIde;
	}

	public String getScoDes() {
		return this.scoDes;
	}

	public void setScoDes(String scoDes) {
		this.scoDes = scoDes;
	}
	
	public TipoConvocatoria getTipoConvocatoria() {
		return tipoConvocatoria;
	}

	public void setTipoConvocatoria(TipoConvocatoria tipoConvocatoria) {
		this.tipoConvocatoria = tipoConvocatoria;
	}

}