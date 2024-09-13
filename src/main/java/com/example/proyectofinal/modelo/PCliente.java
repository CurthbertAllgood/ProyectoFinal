/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectofinal.modelo;
/**
 *
 * @author VGRCAORT
 */
public class PCliente extends Persona{

	public PCliente(Long id, String nombre, String apellido, String rol) {
		super(id, nombre, apellido, rol);
		
		
	}


	private String GET_ALL;
	
	@Override
	public String getReclamos() {
		return GET_ALL=("SELECT * from reclamo where id_Persona='"+ this.getPersonaId()+"'");
			
		
	}
	@Override
	public String getLogs(){
		return GET_ALL=("SELECT * FROM logger WHERE id_Persona='"+this.getPersonaId()+"'");
	}
	
	
}
