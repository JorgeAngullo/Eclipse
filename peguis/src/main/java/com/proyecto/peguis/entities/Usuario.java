package com.proyecto.peguis.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity(name = "usuario")
public class Usuario {
	
	@Id
	@Column(name = "nombre")
	public String nombre;
	
	@Column(name = "contraseña")
	public String contraseña;
	
	public Usuario() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	

}
