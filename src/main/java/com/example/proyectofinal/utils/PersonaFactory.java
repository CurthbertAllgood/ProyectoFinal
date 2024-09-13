/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectofinal.utils;


import com.example.proyectofinal.modelo.Persona;
import com.example.proyectofinal.modelo.PAdmin;
import com.example.proyectofinal.modelo.PCliente;

public class PersonaFactory {


	public static Persona crearPersona(String tipoModelo, Long id, String nombre, String apellido){

		Persona p=init();


		switch(tipoModelo){
			case "Administrador":
				p = new PAdmin(id, nombre, apellido, tipoModelo);
				break;
			case "Contribuyente":
				p = new PCliente(id, nombre, apellido, tipoModelo);
				break;
		}


		return p;
	}


	private static Persona init(){
		return null;
	}





}