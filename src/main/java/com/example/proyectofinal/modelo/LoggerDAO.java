package com.example.proyectofinal.modelo;

import com.example.proyectofinal.dtos.LoggerDto;
import com.example.proyectofinal.utils.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class LoggerDAO {

	private static final String INSERT_LOGGER = "INSERT INTO logger (user_id, fecha, hora, id_Persona) VALUES (?, ?, ?, ?)";
	private static final String GET_ALL_LOGS = "SELECT * FROM logger";

	public int addLog(LoggerDto log) throws SQLException {
		int registroAgregado = 0;
		try (Connection con = Conexion.getConexion();
			 PreparedStatement ps = con.prepareStatement(INSERT_LOGGER)) {
			populatePreparedStatement(ps, log);
			registroAgregado = ps.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException("Error de SQL en el logger", ex);
		}
		return registroAgregado;
	}

	public List<LoggerDto> mostrarList(Long personaId) throws SQLException {
		List<LoggerDto> logs = new ArrayList<>();
		try (Connection con = Conexion.getConexion();
			 PreparedStatement ps = con.prepareStatement(GET_ALL_LOGS + " WHERE id_Persona = ?")) {
			ps.setLong(1, personaId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				logs.add(convertResultSetToLogger(rs));
			}
		} catch (SQLException ex) {
			throw new RuntimeException("Error al obtener datos ", ex);
		}
		return logs;
	}

	private void populatePreparedStatement(PreparedStatement ps, LoggerDto log) throws SQLException {
		ps.setString(1, log.getUserId());
		ps.setDate(2, java.sql.Date.valueOf(log.getDia()));
		ps.setTime(3, java.sql.Time.valueOf(log.getHora()));
		ps.setLong(4, log.getId_Persona());
	}

	private LoggerDto convertResultSetToLogger(ResultSet rs) throws SQLException {
		int id = rs.getInt("id_logger");
		String user = rs.getString("user_id");
		LocalDate fecha = rs.getDate("fecha").toLocalDate();
		LocalTime hora = rs.getTime("hora").toLocalTime();
		Long idPersona = rs.getLong("id_Persona");

		// Usamos valores predeterminados para mensaje y nivel.
		String mensajePredeterminado = "Sin mensaje";
		Level nivelPredeterminado = Level.INFO;

		return new LoggerDto(id, user, fecha, hora, mensajePredeterminado, nivelPredeterminado, idPersona);
	}
}
