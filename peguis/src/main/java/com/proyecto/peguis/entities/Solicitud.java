package com.proyecto.peguis.entities;

import java.io.Serializable;

import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


/**
 * The persistent class for the solicitud database table.
 * 
 */
@Entity
@Table(name="solicitud")
@NamedQuery(name="Solicitud.findAll", query="SELECT s FROM Solicitud s")
public class Solicitud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sol_ide")
	private int solIde;

	@Column(name="sol_con_ide")
	private int solConIde;

	@Column(name="sol_exp_ide")
	private int solExpIde;

	@Column(name="sol_ter_ben")
	private int solTerBen;

	@Column(name="sol_ter_sol")
	private int solTerSol;

	//bi-directional many-to-one association to GrupoTramitacionSolicitud
	@ManyToOne
	@JoinColumn(name="sol_ide_fk", referencedColumnName="gtsSolIde")
	@JsonBackReference
	private GrupoTramitacionSolicitud grupoTramitacionSolicitud;

	public Solicitud() {
	}

	public int getSolIde() {
		return this.solIde;
	}

	public void setSolIde(int solIde) {
		this.solIde = solIde;
	}

	public int getSolConIde() {
		return this.solConIde;
	}

	public void setSolConIde(int solConIde) {
		this.solConIde = solConIde;
	}

	public int getSolExpIde() {
		return this.solExpIde;
	}

	public void setSolExpIde(int solExpIde) {
		this.solExpIde = solExpIde;
	}

	public int getSolTerBen() {
		return this.solTerBen;
	}

	public void setSolTerBen(int solTerBen) {
		this.solTerBen = solTerBen;
	}

	public int getSolTerSol() {
		return this.solTerSol;
	}

	public void setSolTerSol(int solTerSol) {
		this.solTerSol = solTerSol;
	}

	public GrupoTramitacionSolicitud getGrupoTramitacionSolicitud() {
		return this.grupoTramitacionSolicitud;
	}

	public void setGrupoTramitacionSolicitud(GrupoTramitacionSolicitud grupoTramitacionSolicitud) {
		this.grupoTramitacionSolicitud = grupoTramitacionSolicitud;
	}

}