package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mercancia")
public class Mercancia {
	
	@Id
    @Column(name = "id_mercancia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMercancia;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "categoria")
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonIgnoreProperties("mercancia")
    private Cliente cliente;
    
    // Getters and Setters

	public Integer getIdMercancia() {
		return idMercancia;
	}

	public void setIdMercancia(Integer idMercancia) {
		this.idMercancia = idMercancia;
	}

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	// Constructors	
	
	public Mercancia(Integer idMercancia, String nombre, Double precio, Integer cantidad, String categoria,
			Cliente cliente) {
		super();
		this.idMercancia = idMercancia;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.categoria = categoria;
		this.cliente = cliente;
	}

	public Mercancia() {
		super();
	}
    
}
