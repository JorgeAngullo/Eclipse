package com.proyecto.peguis.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


/**
 * The persistent class for the estado_convocatoria database table.
 * 
 */
@Entity
@Table(name="estado_convocatoria")
@NamedQuery(name="EstadoConvocatoria.findAll", query="SELECT e FROM EstadoConvocatoria e")
public class EstadoConvocatoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="esc_ide")
	private String escIde;

	@Column(name="esc_des")
	private String escDes;
	
	public EstadoConvocatoria() {
	}

	public String getEscIde() {
		return this.escIde;
	}

	public void setEscIde(String escIde) {
		this.escIde = escIde;
	}

	public String getEscDes() {
		return this.escDes;
	}

	public void setEscDes(String escDes) {
		this.escDes = escDes;
	}

}