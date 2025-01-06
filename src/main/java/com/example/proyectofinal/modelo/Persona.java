package com.example.proyectofinal.modelo;

import com.example.proyectofinal.dtos.DomicilioDto;
import com.example.proyectofinal.dtos.ReclamoDto;
import com.example.proyectofinal.dtos.UsuarioDto;
import java.util.List;

public abstract class Persona {

	private String rol;
	private Long personaId;
	private String nombre;
	private String apellido;
	private Float dni;
	private String email;
	private Float telefono;
	private List<DomicilioDto> domicilio;
	private List<UsuarioDto> usuario;
	private List<ReclamoDto> reclamoId;

	public Persona(String rol, Long id, String nombre, String apellido, int DNI, String email, int tele) {
		setRol(rol);
		setPersonaId(id);
		setNombre(nombre);
		setApellido(apellido);
		setDni((float) DNI);
		setEmail(email);
		setTelefono((float) tele);
	}

	public Persona(Long id, String nombre, String apellido, String rol) {
		this.personaId = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Float getDni() {
		return dni;
	}

	public void setDni(Float dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Float getTelefono() {
		return telefono;
	}

	public void setTelefono(Float telefono) {
		this.telefono = telefono;
	}

	public List<DomicilioDto> getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(List<DomicilioDto> domicilio) {
		this.domicilio = domicilio;
	}

	public List<UsuarioDto> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<UsuarioDto> usuario) {
		this.usuario = usuario;
	}

	public List<ReclamoDto> getReclamoId() {
		return reclamoId;
	}

	public void setReclamoId(List<ReclamoDto> reclamoId) {
		this.reclamoId = reclamoId;
	}

	public String getReclamos() {
		return null;
	}

	public String getLogs() {
		return null;
	}
}
