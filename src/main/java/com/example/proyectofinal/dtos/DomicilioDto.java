package com.example.proyectofinal.dtos;


public class DomicilioDto {

    private String Direccion;

    private String numeracion;

    private ComunaDto Comuna;

    private CodigoPostalDto CodigoPostal;
    
    private Long idPersona;

	public DomicilioDto() {
	}
    
    
	public String getDireccion(){
		return Direccion;
	}
	
	public String getNumeracion(){
		return numeracion;
		
	}
	
	
    
}



