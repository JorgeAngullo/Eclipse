package com.proyecto.peguis.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the unidad_administrativa database table.
 * 
 */
@Entity
@Table(name="unidad_administrativa")
@NamedQuery(name="UnidadAdministrativa.findAll", query="SELECT u FROM UnidadAdministrativa u")
public class UnidadAdministrativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uad_ide")
	private String uadIde;

	@Column(name="uad_des")
	private String uadDes;

	public UnidadAdministrativa() {
	}

	public String getUadIde() {
		return this.uadIde;
	}

	public void setUadIde(String uadIde) {
		this.uadIde = uadIde;
	}

	public String getUadDes() {
		return this.uadDes;
	}

	public void setUadDes(String uadDes) {
		this.uadDes = uadDes;
	}

}