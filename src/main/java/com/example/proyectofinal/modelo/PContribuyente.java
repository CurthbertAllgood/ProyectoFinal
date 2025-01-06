package com.example.proyectofinal.modelo;

/**
 *
 * @autor VGRCAORT
 */
public class PContribuyente extends Persona {

	public PContribuyente(Long id, String nombre, String apellido, String rol) {
		super(id, nombre, apellido, rol);
	}

	@Override
	public String getReclamos() {
		return "SELECT * FROM reclamo WHERE IdDomicilio IN (SELECT IdDomicilio FROM domicilio WHERE idPersona=?)";
	}

	@Override
	public String getLogs() {
		return "SELECT * FROM logger WHERE id_Persona='" + this.getPersonaId() + "'";
	}
}
