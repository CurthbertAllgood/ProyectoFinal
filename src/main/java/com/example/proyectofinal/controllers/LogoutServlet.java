package com.example.proyectofinal.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {


	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		processRequest(request, response);
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
	}

	
	
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
