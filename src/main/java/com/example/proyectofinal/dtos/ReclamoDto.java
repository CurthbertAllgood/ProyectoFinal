package com.example.proyectofinal.dtos;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ReclamoDto implements Serializable {

	private Long idReclamo;
	private String descripcion;
	private LocalDate fechaCreacion;
	private LocalDate fechaResolucion;
	private CategoriaDto categoriaReclamo;
	private Long idDomicilio;
	private EstadoReclamoDto estado;
	private String detalleResolucion;
	private Long idPersona;

	public ReclamoDto() {
	}

	public ReclamoDto(Long id, String descripcion, LocalDate fechaCreacion, LocalDate fechaResolucion, String categoriaReclamo, Long idPersona) {
		setId(id);
		setDescripcion(descripcion);
		setFechaCreacion(fechaCreacion);
		setFechaResolucion(fechaResolucion);
		setCategoria(categoriaReclamo);
		setPersona(idPersona);
	}

	public ReclamoDto(String descripcion, LocalDate fechaCreacion, String categoria, Long idPersona) {
		setDescripcion(descripcion);
		setFechaCreacion(fechaCreacion);
		setCategoria(categoria);
		setPersona(idPersona);
	}

	// Getters
	public Long getId() {
		return idReclamo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getFechaCreacion() {
		return String.valueOf(Date.valueOf(fechaCreacion));
	}

	public Date getFechaResolucion() {
		return Date.valueOf(fechaResolucion);
	}

	public String getDetalle() {
		return detalleResolucion;
	}

	public String getCategoria() {
		return categoriaReclamo != null ? categoriaReclamo.name() : null;
	}

	public Long getIdDomicilio() {
		return idDomicilio;
	}

	public EstadoReclamoDto getEstadoReclamo() {
		return estado;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	// Setters
	public void setId(Long id) {
		if (id < 0) {
			throw new RuntimeException("Valor de ID incorrecto");
		}
		this.idReclamo = id;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setFechaResolucion(LocalDate fechaResolucion) {
		if (fechaCreacion != null) {
			this.fechaResolucion = fechaResolucion;
		}
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		try {
			this.fechaCreacion = fechaCreacion;
		} catch (DateTimeParseException ex) {
			throw new RuntimeException("La fecha de reclamo no es válida", ex);
		}
	}

	public void setDetalleResolucion(String detalle) {
		if (detalle == null || detalle.trim().isEmpty()) {
			detalleResolucion = "el reclamo sigue en revision";
		} else {
			this.detalleResolucion = detalle;
		}
	}

	public void setCategoria(String categoria) {
		if (categoria != null && !categoria.isEmpty()) {
			this.categoriaReclamo = CategoriaDto.valueOf(categoria);
		} else {
			throw new IllegalArgumentException("Categoría no puede ser nula o vacía");
		}
	}

	public void setPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
}
