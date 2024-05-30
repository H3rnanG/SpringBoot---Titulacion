package com.app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VehiculoDTO {

	@NotBlank(message = "El Modelo es obligatorio")
    private String modelo;

	@NotBlank(message = "La Placa es obligatoria")
    private String placa;

	@NotBlank(message = "La Marca es obligatoria")
    private String marca;
    
	@NotNull(message = "El Consumo por Kilometro es obligatorio")
    private Double consumoKm;

	@NotNull(message = "La Capacidad de Personas es obligatoria")
	@Min(value = 2, message = "La Capacidad de Personas debe ser mayor que 1")
    private Integer capacidadPersonas;
    
	@NotNull(message = "La Capacida de Carga es obligatoria")
    private Double capacidadCargaTn;
	
	@NotBlank(message = "El TUC o CHV es obligatoria")
	private String tucChv;
	
	@NotBlank(message = "La autorizacion es obligatoria")
    private String autorizacion;

    @NotBlank(message = "El Estado es Obligatorio")
    private String estado;

	public String getTucChv() {
		return tucChv;
	}

	public void setTucChv(String tucChv) {
		this.tucChv = tucChv;
	}

	public String getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
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
	
}
