package com.app.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @Column(name = "id_vehiculo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVehiculo;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "placa")
    private String placa;

    @Column(name = "marca")
    private String marca;
    
    @Column(name = "consumo_km")
    private Double consumoKm;

    @Column(name = "capacidad_personas")
    private Integer capacidadPersonas;
    
    @Column(name = "capacidad_carga_tn")
    private Double capacidadCargaTn;
    
    @Column(name = "tuc_chv")
    private String tucChv;
    
    @Column(name = "autorizacion")
    private String autorizacion;

    @Column(name = "estado")
    private String estado;
    
    @OneToMany(mappedBy = "vehiculo")
    private List<GuiaRemision> guiasRemision;
    
    // Getters and Setters

	public Integer getIdVehiculo() {
		return idVehiculo;
	}

	public String getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
	}

	public String getTucChv() {
		return tucChv;
	}

	public void setTucChv(String tucChv) {
		this.tucChv = tucChv;
	}

	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getConsumoKm() {
		return consumoKm;
	}

	public void setConsumoKm(Double consumoKm) {
		this.consumoKm = consumoKm;
	}

	public Integer getCapacidadPersonas() {
		return capacidadPersonas;
	}

	public void setCapacidadPersonas(Integer capacidadPersonas) {
		this.capacidadPersonas = capacidadPersonas;
	}

	public Double getCapacidadCargaTn() {
		return capacidadCargaTn;
	}

	public void setCapacidadCargaTn(Double capacidadCargaTn) {
		this.capacidadCargaTn = capacidadCargaTn;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	// Constructors	
	
	

	public Vehiculo() {
		super();
	}

	public Vehiculo(Integer idVehiculo, String modelo, String placa, String marca, Double consumoKm,
			Integer capacidadPersonas, Double capacidadCargaTn, String tucChv, String autorizacion, String estado) {
		super();
		this.idVehiculo = idVehiculo;
		this.modelo = modelo;
		this.placa = placa;
		this.marca = marca;
		this.consumoKm = consumoKm;
		this.capacidadPersonas = capacidadPersonas;
		this.capacidadCargaTn = capacidadCargaTn;
		this.tucChv = tucChv;
		this.autorizacion = autorizacion;
		this.estado = estado;
	}

	

	
    
}