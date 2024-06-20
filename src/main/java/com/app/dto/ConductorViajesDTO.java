package com.app.dto;

public class ConductorViajesDTO {
	private String nombreConductor;
    private int totalViajes;
    
	public String getNombreConductor() {
		return nombreConductor;
	}
	
	public void setNombreConductor(String nombreConductor) {
		this.nombreConductor = nombreConductor;
	}
	
	public int getTotalViajes() {
		return totalViajes;
	}
	
	public void setTotalViajes(int totalViajes) {
		this.totalViajes = totalViajes;
	}
	
	public ConductorViajesDTO(String nombreConductor, int totalViajes) {
		super();
		this.nombreConductor = nombreConductor;
		this.totalViajes = totalViajes;
	}

}
