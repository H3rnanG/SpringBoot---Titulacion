package com.app.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;
    
    @Column(name = "nombre_razon_social")
    private String nombreRazonSocial;
    
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    
    @Column(name = "numero_documento")
    private String numeroDocumento;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "direccion")	
    private String direccion;
    
    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference
    @JsonIgnoreProperties("cliente")
    private List<Mercancia> mercancia;
    
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    
    // Getters and Setters

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreRazonSocial() {
		return nombreRazonSocial;
	}

	public void setNombreRazonSocial(String nombreRazonSocial) {
		this.nombreRazonSocial = nombreRazonSocial;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	// Constructors
	
	public List<Mercancia> getMercancia() {
		return mercancia;
	}

	public void setMercancia(List<Mercancia> mercancia) {
		this.mercancia = mercancia;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Cliente(Integer idCliente, String nombreRazonSocial, String tipoDocumento, String numeroDocumento,
			String telefono, String correo, String direccion, List<Mercancia> mercancia, LocalDateTime fechaCreacion) {
		super();
		this.idCliente = idCliente;
		this.nombreRazonSocial = nombreRazonSocial;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.mercancia = mercancia;
		this.fechaCreacion = fechaCreacion;
	}

	public Cliente() {
		super();
	}
	
	@PrePersist
	protected void onCreate() {
	    this.fechaCreacion = LocalDateTime.now();
	}


}