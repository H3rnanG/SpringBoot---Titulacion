package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(name = "estado")
    private Integer estado;
    
    // Getters and Setters

	public Integer getIdVehiculo() {
		return idVehiculo;
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

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	// Constructors	
	
	public Vehiculo(Integer idVehiculo, String modelo, String placa, String marca, Double consumoKm,
			Integer capacidadPersonas, Double capacidadCargaTn, Integer estado) {
		super();
		this.idVehiculo = idVehiculo;
		this.modelo = modelo;
		this.placa = placa;
		this.marca = marca;
		this.consumoKm = consumoKm;
		this.capacidadPersonas = capacidadPersonas;
		this.capacidadCargaTn = capacidadCargaTn;
		this.estado = estado;
	}

	public Vehiculo() {
		super();
	}
    
}