package com.example.proyectofinal.modelo;

/**
 *
 * @autor VGRCAORT
 */
public class PAdmin extends Persona {

	public PAdmin(Long id, String nombre, String apellido, String rol) {
		super(id, nombre, apellido, rol);
	}

	@Override
	public String getReclamos() {
		return "SELECT * FROM reclamo";
	}

	@Override
	public String getLogs() {
		return "SELECT * FROM logger";
	}
}
