package com.example.proyectofinal.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;

public class LoggerDto {
	private Integer id;
	private String userId;
	private LocalDate dia;
	private LocalTime hora;
	private String mensaje;
	private Level nivel;
	private long id_Persona;

	// Constructor completo
	public LoggerDto(Integer id, String userId, LocalDate dia, LocalTime hora, String mensaje, Level nivel, long id_Persona) {
		this.id = id;
		this.userId = userId;
		this.dia = dia;
		this.hora = hora;
		this.mensaje = mensaje;
		this.nivel = nivel;
		this.id_Persona = id_Persona;
	}

	// Constructor simplificado sin id (utilizado para crear nuevos logs)
	public LoggerDto(LocalDate dia, LocalTime hora, String userId, long id_Persona) {
		this.dia = dia;
		this.hora = hora;
		this.userId = userId;
		this.id_Persona = id_Persona;
	}

	// Getters y Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Level getNivel() {
		return nivel;
	}

	public void setNivel(Level nivel) {
		this.nivel = nivel;
	}

	public long getId_Persona() {
		return id_Persona;
	}

	public void setId_Persona(long id_Persona) {
		this.id_Persona = id_Persona;
	}
}
