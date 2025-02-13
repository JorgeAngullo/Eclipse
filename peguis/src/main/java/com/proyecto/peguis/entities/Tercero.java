package com.proyecto.peguis.entities;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


/**
 * The persistent class for the tercero database table.
 * 
 */
@Entity
@Table(name="tercero")
@NamedQuery(name="Tercero.findAll", query="SELECT t FROM Tercero t")
public class Tercero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ter_ide")
	private int terIde;

	@Column(name="ter_apellido1")
	private String terApellido1;

	@Column(name="ter_apellido2")
	private String terApellido2;

//	@Temporal(TemporalType.DATE)
	@Column(name="ter_fec_nacimiento")
	private Date terFecNacimiento;

	@Column(name="ter_nombre")
	private String terNombre;

	@Column(name="ter_num_mod")
	private int terNumMod;

	@Column(name="ter_razon_social")
	private String terRazonSocial;

	@Column(name="ter_tipo")
	private String terTipo;

	@Column(name="ter_tipo_ter")
	private String terTipoTer;

	//bi-directional one-to-one association to Tercero
	@OneToOne
	@JoinColumn(name="ter_tut_ide")
	private Tercero tercero1;

	//bi-directional one-to-one association to Tercero
	@OneToOne(mappedBy="tercero1")
	private Tercero tercero2;

	public Tercero() {
	}

	public int getTerIde() {
		return this.terIde;
	}

	public void setTerIde(int terIde) {
		this.terIde = terIde;
	}

	public String getTerApellido1() {
		return this.terApellido1;
	}

	public void setTerApellido1(String terApellido1) {
		this.terApellido1 = terApellido1;
	}

	public String getTerApellido2() {
		return this.terApellido2;
	}

	public void setTerApellido2(String terApellido2) {
		this.terApellido2 = terApellido2;
	}

	public Date getTerFecNacimiento() {
		return this.terFecNacimiento;
	}

	public void setTerFecNacimiento(Date terFecNacimiento) {
		this.terFecNacimiento = terFecNacimiento;
	}

	public String getTerNombre() {
		return this.terNombre;
	}

	public void setTerNombre(String terNombre) {
		this.terNombre = terNombre;
	}

	public int getTerNumMod() {
		return this.terNumMod;
	}

	public void setTerNumMod(int terNumMod) {
		this.terNumMod = terNumMod;
	}

	public String getTerRazonSocial() {
		return this.terRazonSocial;
	}

	public void setTerRazonSocial(String terRazonSocial) {
		this.terRazonSocial = terRazonSocial;
	}

	public String getTerTipo() {
		return this.terTipo;
	}

	public void setTerTipo(String terTipo) {
		this.terTipo = terTipo;
	}

	public String getTerTipoTer() {
		return this.terTipoTer;
	}

	public void setTerTipoTer(String terTipoTer) {
		this.terTipoTer = terTipoTer;
	}

	public Tercero getTercero1() {
		return this.tercero1;
	}

	public void setTercero1(Tercero tercero1) {
		this.tercero1 = tercero1;
	}

	public Tercero getTercero2() {
		return this.tercero2;
	}

	public void setTercero2(Tercero tercero2) {
		this.tercero2 = tercero2;
	}

}