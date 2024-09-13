package com.example.proyectofinal.modelo;

import com.example.proyectofinal.dtos.ReclamoDto;
import com.example.proyectofinal.utils.Conexion;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReclamoDAO {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/municipio_ortiz_carlos?allowPublicKeyRetrieval=true&useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "Prisma01";
	private static final String ADD_RECLAMO = "INSERT INTO reclamo (Descripcion, Fecha_Creacion, Categoria, id_Persona) VALUES (?, ?, ?, ?)";
	private Conexion generaConexion;
	private String GET_ALL;

	public List<ReclamoDto> getReclamos(Persona p) throws SQLException {
		List<ReclamoDto> listaReclamo = new ArrayList<>();
		GET_ALL = p.getReclamos();
		try (Connection con = Conexion.getConexion(DRIVER, URL, USER, PASS); PreparedStatement ps = con.prepareStatement(GET_ALL)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				listaReclamo.add(rsReclamo(rs));
			}
		} catch (SQLException ex) {
			throw new RuntimeException("Error al obtener datos ", ex);
		}
		return listaReclamo;
	}

	public int add(ReclamoDto reclamo) {
		int regsAgregados = 0;
		try (Connection con = Conexion.getConexion(DRIVER, URL, USER, PASS); PreparedStatement ps = con.prepareStatement(ADD_RECLAMO)) {
			generaReclamo(ps, reclamo);
			regsAgregados = ps.executeUpdate();
			System.out.printf("se agrego el reclamo");
		} catch (SQLException ex) {
			throw new RuntimeException("No se logró cargar en la BD", ex);
		} catch (RuntimeException ex) {
			throw new RuntimeException("Hubo un error en la generación del reclamo", ex);
		}
		return regsAgregados;
	}

	public void generaReclamo(PreparedStatement ps, ReclamoDto rec) throws SQLException {
		ps.setString(1, rec.getDescripcion());
		ps.setDate(2, Date.valueOf(rec.getFechaCreacion()));
		ps.setString(3, rec.getCategoria());
		ps.setLong(4, rec.getIdPersona());
	}

	private ReclamoDto rsReclamo(ResultSet rs) throws SQLException {
		String fechaCreacion = rs.getString("Fecha_Creacion");
		String descripcion = rs.getString("Descripcion");
		String categoria = rs.getString("Categoria");
		Long idPersona = rs.getLong("id_Persona");
		return new ReclamoDto(descripcion, LocalDate.parse(fechaCreacion),categoria, idPersona);
	}
}
