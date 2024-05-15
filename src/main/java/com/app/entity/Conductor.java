package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "conductor")
public class Conductor {

    @Id
    @Column(name = "id_conductor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConductor;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private int correo;
    
    @Column(name = "tipo_licencia")
    private int tipo_licencia;
    
    @Column(name = "licencia")
    private int licencia;

    @Column(name = "estado")
    private int estado;

	public int getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(int idConductor) {
		this.idConductor = idConductor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getCorreo() {
		return correo;
	}

	public void setCorreo(int correo) {
		this.correo = correo;
	}

	public int getTipo_licencia() {
		return tipo_licencia;
	}

	public void setTipo_licencia(int tipo_licencia) {
		this.tipo_licencia = tipo_licencia;
	}

	public int getLicencia() {
		return licencia;
	}

	public void setLicencia(int licencia) {
		this.licencia = licencia;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Conductor(int idConductor, String nombre, String telefono, int correo, int tipo_licencia, int licencia,
			int estado) {
		super();
		this.idConductor = idConductor;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.tipo_licencia = tipo_licencia;
		this.licencia = licencia;
		this.estado = estado;
	}

	public Conductor() {
		super();
	}
    
}