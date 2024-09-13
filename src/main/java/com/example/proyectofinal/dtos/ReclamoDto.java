package com.example.proyectofinal.dtos;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class ReclamoDto implements Serializable{

	
    private Long idReclamo;
    
    private String descripcion;
    
    private LocalDate fechaCrecion;
    
    private LocalDate fechaResolucion;

    private CategoriaDto categoriaReclamo;

    private Long idDomicilio;

    private EstadoReclamoDto Estado;

    private String DetalleResolucion;
    
    private Long idPersona;

	
	public ReclamoDto(){
		
	}


	public ReclamoDto(Long id, String descripcion, LocalDate fechaCreacion, LocalDate fechaResolucion, String categoria, Long idPersona) {
		setId(id);
		setDescripcion(descripcion);
		setFechaCreacion(fechaCreacion);
		setFechaResolucion(fechaResolucion);
		setCategoria(categoria);
		setPersona(idPersona);
	}

	public ReclamoDto(String descripcion, LocalDate fechaCreacion, String categoria, Long idPersona) {
		setDescripcion(descripcion);
		setFechaCreacion(fechaCreacion);
		setCategoria(getCategoria());
		setPersona(idPersona);
	}



	//Getters 
	
	public Long getId(){
		return idReclamo;
	}
	
	public String getDescripcion(){
		return descripcion;
	}
	
	public String getFechaCreacion(){
		return String.valueOf(Date.valueOf(fechaCrecion));
	}
	
	public Date getFechaResolucion(){
		return Date.valueOf(fechaResolucion);
	}
	
	public String getDetalle(){
		return DetalleResolucion;
	}
	
	public String getCategoria(){
		return String.valueOf(categoriaReclamo);

	}
	
	
	public Long getIdDomicilio(){
		return idDomicilio;
	}
	
	
	public EstadoReclamoDto getEstadoReclamo(){
		EstadoReclamoDto er=null;
		return er;
	}
	
	public Long getIdPersona(){
		return idPersona;
	}

	
	// INICIO SETTERS
	
	//Set Id ReclamoDTO FUNCIONA
	
	public long setId(Long id){
		if(id<0){
			throw new RuntimeException("Valor de ID incorrecto");
		}
		return	this.idReclamo=id;
	}

	//Set Descripcion de reclamo FUNCIONA

	public String setDescripcion(String Descripcion) {
		
		return this.descripcion=Descripcion;
		
	}

	//Set fecha de resolucion NO FUNCIONA, tira null pointer exception
	
	public void setFechaResolucion(LocalDate fechaResolucion) {
		if(fechaCrecion!=null) {
			this.fechaResolucion = LocalDate.now();
		}

	}
	
	
	//set fecha Creacion FUNCIONA

	public void setFechaCreacion(LocalDate fechaCreacion) {
		try{
		LocalDate fechaFinal= fechaCreacion;
		this.fechaCrecion = fechaFinal;
		}catch(DateTimeParseException ex){
			throw new RuntimeException("La fecha de reclamo no es válida", ex);
		}
	}
	//Setea detalles de resolucion de incidente, por el momento NO FUNCIONA
	
	public void setDetalleResolucion(String detalle) {
		if(DetalleResolucion==null || detalle.trim().isEmpty()){
			DetalleResolucion="el reclamo sigue en revision";
		}
		this.DetalleResolucion=detalle;
	}

	//NO SE SETEO TODAVIA
	public void setCategoria(String categoria) {
        CategoriaDto.valueOf(categoria);
    }

	
	// NO SE SETEO TODAVIA
	public void setPersona(Long idPersona) {
		Long persona=idPersona;
	}




}
	
		

