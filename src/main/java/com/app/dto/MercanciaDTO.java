package com.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MercanciaDTO {

    @NotBlank(message = "El Nombre es obligatorio")
    private String nombre;

    @NotNull(message = "El Precio es obligatorio")
    private Double precio;

    @NotNull(message = "La Cantidad es obligatoria")
    private Integer cantidad;

    @NotBlank(message = "La Categoría es obligatoria")
    private String categoria;

    @NotNull(message = "El Cliente es obligatorio")
    private Integer idCliente;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

}