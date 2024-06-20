package com.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClienteDTO {

	@NotBlank(message = "El Nombre o Razon Social es obligatorio")
	private String nombreRazonSocial;
	
	@NotBlank(message = "El Tipo de Documento es obligatorio")
    private String tipoDocumento;
	
	@NotBlank(message = "El Numero de Documento es obligatorio")
    private String numeroDocumento;
	
	@NotBlank(message = "El Telefono es obligatorio")
    private String telefono;
	
	@Email(message = "El Correo es invalido")
	@NotBlank(message = "El Correo es obligatorio")
    private String correo;
	
	@NotBlank(message = "La Direccion es obligatorio")
    private String direccion;
	
	// Getters and Setters

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
	
}
