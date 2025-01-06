package com.example.proyectofinal.controllers;

import com.example.proyectofinal.dtos.ReclamoDto;
import com.example.proyectofinal.modelo.Persona;
import com.example.proyectofinal.modelo.ReclamoDAO;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ReclamoServlet", urlPatterns = {"/reclamos"})
public class ReclamoServlet extends HttpServlet {

    private ReclamoDAO model;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Persona m = (Persona) session.getAttribute("userLogueado");

        if (m != null) {
            try {
                List<ReclamoDto> reclamos = model.getReclamos(m);
                // Validación adicional para categoría nula o vacía
                for (ReclamoDto reclamo : reclamos) {
                    if (reclamo.getCategoria() == null || reclamo.getCategoria().isEmpty()) {
                        Logger.getLogger(ReclamoServlet.class.getName()).log(Level.SEVERE, "Categoría nula o vacía en reclamos obtenidos");
                        throw new IllegalArgumentException("Categoría no puede ser nula o vacía");
                    }
                }
                request.setAttribute("listaReclamos", reclamos);
                System.out.println("Reclamos obtenidos para usuario: " + m);
            } catch (SQLException ex) {
                Logger.getLogger(ReclamoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("/pages/reclamos.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implementar la lógica del POST si es necesario
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    @Override
    public void init() throws ServletException {
        model = new ReclamoDAO();
    }
}
