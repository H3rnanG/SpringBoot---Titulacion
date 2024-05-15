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
    private int idVehiculo;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "placa")
    private int placa;

    @Column(name = "marca")
    private int marca;
    
    @Column(name = "gasolina_km")
    private int gasolinaKm;

    @Column(name = "capacidad_personas")
    private int capacidadPersonas;
    
    @Column(name = "capacidad_carga")
    private int capacidadCarga;

    @Column(name = "estado")
    private int estado;

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPlaca() {
		return placa;
	}

	public void setPlaca(int placa) {
		this.placa = placa;
	}

	public int getMarca() {
		return marca;
	}

	public void setMarca(int marca) {
		this.marca = marca;
	}

	public int getGasolinaKm() {
		return gasolinaKm;
	}

	public void setGasolinaKm(int gasolinaKm) {
		this.gasolinaKm = gasolinaKm;
	}

	public int getCapacidadPersonas() {
		return capacidadPersonas;
	}

	public void setCapacidadPersonas(int capacidadPersonas) {
		this.capacidadPersonas = capacidadPersonas;
	}

	public int getCapacidadCarga() {
		return capacidadCarga;
	}

	public void setCapacidadCarga(int capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Vehiculo(int idVehiculo, String modelo, int placa, int marca, int gasolinaKm, int capacidadPersonas,
			int capacidadCarga, int estado) {
		super();
		this.idVehiculo = idVehiculo;
		this.modelo = modelo;
		this.placa = placa;
		this.marca = marca;
		this.gasolinaKm = gasolinaKm;
		this.capacidadPersonas = capacidadPersonas;
		this.capacidadCarga = capacidadCarga;
		this.estado = estado;
	}

	public Vehiculo() {
		super();
	}

}