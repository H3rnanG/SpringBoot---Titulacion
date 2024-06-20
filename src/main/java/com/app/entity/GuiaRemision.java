package com.app.entity;

import java.time.LocalDateTime;
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
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "guia_remision")
public class GuiaRemision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_guia_remision")
    private Integer idGuiaRemision;

    @Column(name = "guia")
    private String guia;

    @ManyToOne
    @JoinColumn(name = "id_cliente_remitente", referencedColumnName = "id_cliente")
    private Cliente remitente;

    @Column(name = "documento_destinatario")
    private Long documentoDestinatario;

    @Column(name = "tipo_documento_destinatario")
    private String tipoDocumentoDestinatario;

    @Column(name = "destinatario")
    private String destinatario;

    @Column(name = "fecha_emision")
    private String fechaEmision;

    @Column(name = "inicio_traslado")
    private String inicioTraslado;
    
    @Column(name = "documentId")
    private String documentId;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "id_conductor")
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

    @Column(name = "peso_bruto")
    private Double pesoBruto;

    @OneToMany(mappedBy = "guiaRemision", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mercancia> mercancias;
    
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

	public Integer getIdGuiaRemision() {
		return idGuiaRemision;
	}

	public void setIdGuiaRemision(Integer idGuiaRemision) {
		this.idGuiaRemision = idGuiaRemision;
	}

	public String getGuia() {
		return guia;
	}

	public void setGuia(String guia) {
		this.guia = guia;
	}

	public Cliente getRemitente() {
		return remitente;
	}

	public void setRemitente(Cliente remitente) {
		this.remitente = remitente;
	}

	public Long getDocumentoDestinatario() {
		return documentoDestinatario;
	}

	public void setDocumentoDestinatario(Long documentoDestinatario) {
		this.documentoDestinatario = documentoDestinatario;
	}

	public String getTipoDocumentoDestinatario() {
		return tipoDocumentoDestinatario;
	}

	public void setTipoDocumentoDestinatario(String tipoDocumentoDestinatario) {
		this.tipoDocumentoDestinatario = tipoDocumentoDestinatario;
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
	
	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public GuiaRemision(Integer idGuiaRemision, String guia, Cliente remitente, Long documentoDestinatario,
			String tipoDocumentoDestinatario, String destinatario, String fechaEmision, String inicioTraslado,
			String documentId, Vehiculo vehiculo, Conductor conductor, Integer ubicacionPartida,
			String direccionPartida, Integer ubicacionLlegada, String direccionLlegada, String medidaPeso,
			Double pesoBruto, List<Mercancia> mercancias) {
		super();
		this.idGuiaRemision = idGuiaRemision;
		this.guia = guia;
		this.remitente = remitente;
		this.documentoDestinatario = documentoDestinatario;
		this.tipoDocumentoDestinatario = tipoDocumentoDestinatario;
		this.destinatario = destinatario;
		this.fechaEmision = fechaEmision;
		this.inicioTraslado = inicioTraslado;
		this.documentId = documentId;
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

	public GuiaRemision() {
		super();
	}
	
	@PrePersist
	protected void onCreate() {
	    this.fechaCreacion = LocalDateTime.now();
	}
    
}
