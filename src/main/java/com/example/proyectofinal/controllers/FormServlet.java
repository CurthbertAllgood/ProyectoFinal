package com.example.proyectofinal.controllers;

import java.io.IOException;
import java.time.LocalDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.proyectofinal.modelo.ReclamoDAO;
import com.example.proyectofinal.dtos.ReclamoDto;

@WebServlet(name = "FormularioServlet", urlPatterns = {"/form"})
public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login?origen=form");
        } else {
            request.getRequestDispatcher("/pages/formulario.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String descripcion = request.getParameter("Detalle");
        String tipoReclamo = request.getParameter("tipoReclamo");
        Long idPersona = 1L; // Puedes obtener el ID de la persona desde la sesión o formulario

        ReclamoDto reclamo = new ReclamoDto(descripcion, LocalDate.now(), tipoReclamo, idPersona);
        ReclamoDAO reclamoDAO = new ReclamoDAO();
        reclamoDAO.add(reclamo);
        System.out.println("entraste a la generacion de datos");

        response.sendRedirect(request.getContextPath() + "/success");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
