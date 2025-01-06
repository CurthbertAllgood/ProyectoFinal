package com.example.proyectofinal.modelo;

import com.example.proyectofinal.dtos.LoggerDto;
import com.example.proyectofinal.dtos.UsuarioDto;
import com.example.proyectofinal.utils.Conexion;
import com.example.proyectofinal.utils.PersonaFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class UsuarioDAO {
	private PersonaFactory model;
	private UsuarioDto usu;
	private LoggerDto log;

	public Persona autenticar(String user, String password) throws SQLException {
		Persona p = null;
		usu = new UsuarioDto(user, password);
		LoggerDAO logger = new LoggerDAO();
		try (Connection con = Conexion.getConexion();
			 PreparedStatement ps = con.prepareStatement("SELECT u.rol, p.IdPersona, p.nombre, p.apellido FROM usuario u INNER JOIN persona p ON u.IdPersona = p.IdPersona WHERE u.contrasena = ? AND u.nombre_usuario = ?")) {
			ps.setString(1, usu.getPass());
			System.out.println("Password: " + usu.getPass());
			ps.setString(2, usu.getUserId());
			System.out.println("User ID: " + usu.getUserId());
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					System.out.println("Creating Persona instance...");
					p = PersonaFactory.crearPersona(rs.getString("rol"), rs.getLong("IdPersona"), rs.getString("nombre"), rs.getString("apellido"));
					if (p != null) {
						log = new LoggerDto(LocalDate.now(), LocalTime.now(), usu.getUserId(), p.getPersonaId());
						logger.addLog(log);
						System.out.println("User authenticated successfully. Persona ID: " + p.getPersonaId());
					} else {
						System.err.println("Failed to create Persona instance.");
					}
				} else {
					System.out.println("User authentication failed. No matching records found.");
				}
			} catch (SQLException ex) {
				System.err.println("SQL Error: " + ex.getMessage());
				throw new RuntimeException("Error de SQL", ex);
			} catch (Exception ex) {
				System.err.println("Error: " + ex.getMessage());
				throw new RuntimeException("Error al agregar Usuario", ex);
			}
		} catch (SQLException ex) {
			System.err.println("Connection Error: " + ex.getMessage());
			throw new RuntimeException("Error de conexión", ex);
		}
		return p;
	}
}
