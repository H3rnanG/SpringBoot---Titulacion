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
    private Integer idConductor;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;
    
    @Column(name = "tipo_licencia")
    private String tipo_licencia;
    
    @Column(name = "licencia")
    private String licencia;

    @Column(name = "estado")
    private String estado;

    // Getters and Setters
    
	public Integer getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(Integer idConductor) {
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTipo_licencia() {
		return tipo_licencia;
	}

	public void setTipo_licencia(String tipo_licencia) {
		this.tipo_licencia = tipo_licencia;
	}

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	// Constructors	
	
	public Conductor(Integer idConductor, String nombre, String telefono, String correo, String tipo_licencia,
			String licencia, String estado) {
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