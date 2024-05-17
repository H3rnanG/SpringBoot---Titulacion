package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class GuiaRemisionDTO {

    @NotNull(message = "El RUC del remitente es obligatorio")
    private Long rucRemitente;

    @NotBlank(message = "El nombre del remitente es obligatorio")
    private String remitente;

    @NotNull(message = "El RUC del destinatario es obligatorio")
    private Long rucDestinatario;

    @NotBlank(message = "El nombre del destinatario es obligatorio")
    private String destinatario;

    @NotBlank(message = "La fecha de emisión es obligatoria")
    private String fechaEmision;

    @NotBlank(message = "El inicio del traslado es obligatorio")
    private String inicioTraslado;

    @NotNull(message = "El vehículo es obligatorio")
    private Integer idVehiculo;

    @NotNull(message = "El conductor es obligatorio")
    private Integer idConductor;

    @NotNull(message = "La ubicación de partida es obligatoria")
    private Integer ubicacionPartida;

    @NotBlank(message = "La dirección de partida es obligatoria")
    private String direccionPartida;

    @NotNull(message = "La ubicación de llegada es obligatoria")
    private Integer ubicacionLlegada;

    @NotBlank(message = "La dirección de llegada es obligatoria")
    private String direccionLlegada;

    @NotBlank(message = "La medida de peso es obligatoria")
    private String medidaPeso;

    @NotNull(message = "El peso bruto es obligatorio")
    private Double pesoBruto;

	public Long getRucRemitente() {
		return rucRemitente;
	}

	public void setRucRemitente(Long rucRemitente) {
		this.rucRemitente = rucRemitente;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public Long getRucDestinatario() {
		return rucDestinatario;
	}

	public void setRucDestinatario(Long rucDestinatario) {
		this.rucDestinatario = rucDestinatario;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getInicioTraslado() {
		return inicioTraslado;
	}

	public void setInicioTraslado(String inicioTraslado) {
		this.inicioTraslado = inicioTraslado;
	}

	public Integer getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Integer getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(Integer idCliente) {
		this.idConductor = idCliente;
	}

	public Integer getUbicacionPartida() {
		return ubicacionPartida;
	}

	public void setUbicacionPartida(Integer ubicacionPartida) {
		this.ubicacionPartida = ubicacionPartida;
	}

	public String getDireccionPartida() {
		return direccionPartida;
	}

	public void setDireccionPartida(String direccionPartida) {
		this.direccionPartida = direccionPartida;
	}

	public Integer getUbicacionLlegada() {
		return ubicacionLlegada;
	}

	public void setUbicacionLlegada(Integer ubicacionLlegada) {
		this.ubicacionLlegada = ubicacionLlegada;
	}

	public String getDireccionLlegada() {
		return direccionLlegada;
	}

	public void setDireccionLlegada(String direccionLlegada) {
		this.direccionLlegada = direccionLlegada;
	}

	public String getMedidaPeso() {
		return medidaPeso;
	}

	public void setMedidaPeso(String medidaPeso) {
		this.medidaPeso = medidaPeso;
	}

	public Double getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(Double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

    // Getters and Setters
    
    
}