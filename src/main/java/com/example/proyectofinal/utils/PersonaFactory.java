package com.example.proyectofinal.utils;

import com.example.proyectofinal.modelo.Persona;
import com.example.proyectofinal.modelo.PAdmin;
import com.example.proyectofinal.modelo.PContribuyente;

public class PersonaFactory {

	public static Persona crearPersona(String tipoModelo, Long id, String nombre, String apellido) {

        return switch (tipoModelo) {
case "admin" -> new PAdmin(id, nombre, apellido, tipoModelo);
case "contribuyente" -> new PContribuyente(id, nombre, apellido, tipoModelo);
default -> throw new IllegalArgumentException("Tipo de modelo desconocido: " + tipoModelo);
};
	}
}
