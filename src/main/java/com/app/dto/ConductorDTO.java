package com.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ConductorDTO {

    @NotBlank(message = "El Nombre es obligatorio")
    private String nombre;
    
    @NotBlank(message = "El Apellido es obligatorio")
    private String apellido;

    @NotBlank(message = "El Teléfono es obligatorio")
    private String telefono;
    
    @NotBlank(message = "El DNI es obligatorio")
    private String dni;

    @Email(message = "El Correo electrónico es inválido")
    @NotBlank(message = "El Correo electrónico es obligatorio")
    private String correo;
    
    @NotBlank(message = "El Tipo de Licencia es obligatorio")
    private String tipoLicencia;
    
    @NotBlank(message = "La Licencia es obligatoria")
    private String licencia;

    @NotBlank(message = "El Estado es obligatorio")
    private String estado;

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getTipoLicencia() {
		return tipoLicencia;
	}

	public void setTipoLicencia(String tipoLicencia) {
		this.tipoLicencia = tipoLicencia;
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
    
}
