package com.app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "guia-remisison")
public class GuiaRemision {

	@Id
    @Column(name = "id_mercancia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMercancia;
	
	@Column(name = "ruc_remitente")
    private Long rucRemitente;
	
	@Column(name = "remitente")
    private String remitente;
	
	@Column(name = "ruc_destinatario")
    private Long rucDestinatario;
	
	@Column(name = "destinatario")
    private String destinatario;
	
	@Column(name = "fecha_emision")
    private String fechaEmision;
	
	@Column(name = "inicio_traslado")
    private String inicioTraslado;
	
	@ManyToOne
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    private Vehiculo vehiculo;
	
	@ManyToOne
    @JoinColumn(name = "id_conductor", referencedColumnName = "id_conductor")
    private Conductor conductor;
	
	@Column(name = "ubicacion_partida")
    private Integer ubicacionPartida;
	
	@Column(name = "direccion_partida")
    private String direccionPartida;
	
	@Column(name = "ubicacion_llegada")
    private Integer ubicacionLlegada;
	
	@Column(name = "direccion_llegada")
    private String direccionLlegada;
	
	@Column(name = "medida_peso")
    private String medidaPeso;
	
	@Column(name = "pesoBruto")
    private Double pesoBruto;
	
	@OneToMany(mappedBy = "guiaRemision", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Mercancia> mercancias;
	
	// Getters and Setter

	

	public GuiaRemision() {
		super();
	}

	public GuiaRemision(Integer idMercancia, Long rucRemitente, String remitente, Long rucDestinatario,
			String destinatario, String fechaEmision, String inicioTraslado, Vehiculo vehiculo, Conductor conductor,
			Integer ubicacionPartida, String direccionPartida, Integer ubicacionLlegada, String direccionLlegada,
			String medidaPeso, Double pesoBruto, List<Mercancia> mercancias) {
		super();
		this.idMercancia = idMercancia;
		this.rucRemitente = rucRemitente;
		this.remitente = remitente;
		this.rucDestinatario = rucDestinatario;
		this.destinatario = destinatario;
		this.fechaEmision = fechaEmision;
		this.inicioTraslado = inicioTraslado;
		this.vehiculo = vehiculo;
		this.conductor = conductor;
		this.ubicacionPartida = ubicacionPartida;
		this.direccionPartida = direccionPartida;
		this.ubicacionLlegada = ubicacionLlegada;
		this.direccionLlegada = direccionLlegada;
		this.medidaPeso = medidaPeso;
		this.pesoBruto = pesoBruto;
		this.mercancias = mercancias;
	}

	public Integer getIdMercancia() {
		return idMercancia;
	}

	public void setIdMercancia(Integer idMercancia) {
		this.idMercancia = idMercancia;
	}

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

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
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

	public List<Mercancia> getMercancias() {
		return mercancias;
	}

	public void setMercancias(List<Mercancia> mercancias) {
		this.mercancias = mercancias;
	}
	
}