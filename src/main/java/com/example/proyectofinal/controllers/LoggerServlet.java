package com.example.proyectofinal.controllers;

import com.example.proyectofinal.modelo.Persona;
import com.example.proyectofinal.modelo.LoggerDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;

@WebServlet(name = "LoggerServlet", urlPatterns = {"/loggers"})
public class LoggerServlet extends HttpServlet {

	private LoggerDAO model;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Persona m = (Persona) session.getAttribute("userLogueado");

		if (m != null) {
			try {
				// Pasar el ID de la persona en lugar del objeto Persona completo
				request.setAttribute("listaLogins", model.mostrarList(m.getPersonaId()));
			} catch (SQLException ex) {
				System.out.println("Error generando la lista de logs");
			}
			request.getRequestDispatcher("/pages/loggers.jsp").forward(request, response);
		} else {
			// Si no hay usuario logueado, redirigir al login o manejar el error
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}

	@Override
	public void init() throws ServletException {
		model = new LoggerDAO();
	}
}
