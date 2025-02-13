package com.proyecto.peguis.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the tipo_convocatoria database table.
 * 
 */
@Entity
@Table(name="tipo_convocatoria")
@NamedQuery(name="TipoConvocatoria.findAll", query="SELECT t FROM TipoConvocatoria t")
public class TipoConvocatoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tco_ide")
	private String tcoIde;

	@Column(name="tco_des")
	private String tcoDes;
	
	@OneToMany(mappedBy="tipoConvocatoria")
	@JsonBackReference
	private List<SubtipoConvocatoria> subtipoConvocatoria;

	public TipoConvocatoria() {
	}

	public String getTcoIde() {
		return this.tcoIde;
	}

	public void setTcoIde(String tcoIde) {
		this.tcoIde = tcoIde;
	}

	public String getTcoDes() {
		return this.tcoDes;
	}

	public void setTcoDes(String tcoDes) {
		this.tcoDes = tcoDes;
	}

	public List<SubtipoConvocatoria> getSubtipoConvocatoria() {
		return subtipoConvocatoria;
	}

	public void setSubtipoConvocatoria(List<SubtipoConvocatoria> subtipoConvocatoria) {
		this.subtipoConvocatoria = subtipoConvocatoria;
	}

}