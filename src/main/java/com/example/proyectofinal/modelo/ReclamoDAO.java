package com.example.proyectofinal.modelo;

import com.example.proyectofinal.dtos.ReclamoDto;
import com.example.proyectofinal.utils.Conexion;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReclamoDAO {

	private static final Logger logger = Logger.getLogger(ReclamoDAO.class.getName());
	private static final String ADD_RECLAMO = "INSERT INTO reclamo (descripcion, fecha_creacion, categoria, IdDomicilio) VALUES (?, ?, ?, ?)";

	public List<ReclamoDto> getReclamos(Persona persona) throws SQLException {
		List<ReclamoDto> listaReclamo = new ArrayList<>();
		try (Connection con = Conexion.getConexion()) {
			logger.log(Level.INFO, "Conexión establecida");
			String query = persona.getReclamos();
			logger.log(Level.INFO, "Consulta: {0}", query);
			try (PreparedStatement ps = con.prepareStatement(query)) {
				if (persona instanceof PContribuyente) {
					ps.setLong(1, persona.getPersonaId()); // Establecer el parámetro IdPersona para PContribuyente
					logger.log(Level.INFO, "Parámetro IdPersona establecido: {0}", persona.getPersonaId());
				}
				ResultSet rs = ps.executeQuery();
				logger.log(Level.INFO, "Consulta ejecutada");
				while (rs.next()) {
					listaReclamo.add(rsReclamo(rs));
				}
			}
		} catch (SQLException ex) {
			logger.log(Level.SEVERE, "Error al obtener datos", ex);
			throw new RuntimeException("Error al obtener datos ", ex);
		}
		return listaReclamo;
	}

	public int addReclamo(ReclamoDto reclamo) {
		int regsAgregados = 0;
		try (Connection con = Conexion.getConexion();
			 PreparedStatement ps = con.prepareStatement(ADD_RECLAMO)) {
			generaReclamo(ps, reclamo);
			regsAgregados = ps.executeUpdate();
			System.out.println("Se agregó el reclamo");
		} catch (SQLException ex) {
			throw new RuntimeException("No se logró cargar en la BD", ex);
		} catch (RuntimeException ex) {
			throw new RuntimeException("Hubo un error en la generación del reclamo", ex);
		}
		return regsAgregados;
	}

	private void generaReclamo(PreparedStatement ps, ReclamoDto rec) throws SQLException {
		if (rec.getCategoria() == null || rec.getCategoria().isEmpty()) {
			Logger.getLogger(ReclamoDAO.class.getName()).log(Level.SEVERE, "Categoría nula o vacía al generar reclamo");
			throw new IllegalArgumentException("Categoría no puede ser nula o vacía");
		}
		ps.setString(1, rec.getDescripcion());
		ps.setDate(2, Date.valueOf(rec.getFechaCreacion()));
		ps.setString(3, rec.getCategoria());
		ps.setLong(4, rec.getIdPersona());
	}


	private ReclamoDto rsReclamo(ResultSet rs) throws SQLException {
		String fechaCreacion = rs.getString("fecha_creacion");
		String descripcion = rs.getString("descripcion");
		String categoria =  rs.getString("categoria");

		// Log para verificación
		if (categoria == null || categoria.isEmpty()) {
			Logger.getLogger(ReclamoDAO.class.getName()).log(Level.SEVERE, "Categoría es nula o vacía en ResultSet");
			throw new IllegalArgumentException("Categoría no puede ser nula o vacía en ResultSet");
		}

		Long idDomicilio = rs.getLong("IdDomicilio");
		return new ReclamoDto(descripcion, LocalDate.parse(fechaCreacion), categoria, idDomicilio);
	}
}
