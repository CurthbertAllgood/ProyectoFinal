/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example.proyectofinal.controllers;

import com.example.proyectofinal.modelo.Persona;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.example.proyectofinal.modelo.Logger;
import java.sql.SQLException;

/**
 *
 * @author VGRCAORT
 */
@WebServlet(name = "LoggerServlet", urlPatterns = {"/loggers"})
public class LoggerServlet extends HttpServlet {


	private Logger model;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

	}



	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Persona m = (Persona) session.getAttribute("userLogueado");
		try {
			request.setAttribute("listaLogins", model.mostrarList(m));
		} catch (SQLException ex) {
			System.out.println("error generando la lista");
		}
		request.getRequestDispatcher("/pages/loggers.jsp").forward(request, response);

	}



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}



	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

	@Override
	public void init() throws ServletException {
		model= new Logger();
	}
}