/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectofinal.modelo;

/**
 *
 * @author VGRCAORT
 */
public class PAdmin extends Persona{

	private String GET_ALL="select * from reclamo";
	
	public PAdmin(Long id, String nombre, String apellido, String rol) {
		super(id, nombre, apellido, rol);
	}
	

	
	@Override
	public String getReclamos() {
		
		return GET_ALL;
	}
	@Override
	public String getLogs(){
		return GET_ALL=("SELECT * FROM logger");
	}

	
}
