
package com.example.proyectofinal.controllers;
import com.example.proyectofinal.modelo.Persona;
import com.example.proyectofinal.modelo.ReclamoDAO;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//DoGet y DoPost es un pasador de datos, no tiene logica

// Servlet Para mostrar y generar Reclamos
@WebServlet(name = "ReclamoServlet", urlPatterns = {"/reclamos"})
public class ReclamoServlet extends HttpServlet {

    private ReclamoDAO model;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Persona m = (Persona) session.getAttribute("userLogueado");
        System.out.println(m.getApellido());
        System.out.println(m.getNombre());
        System.out.println(m.getPersonaId());
        System.out.println(m.getRol());
        System.out.println(m);
        try {
            request.setAttribute("listaReclamos", model.getReclamos(m));
        } catch (SQLException ex) {
            Logger.getLogger(ReclamoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/pages/reclamos.jsp").forward(request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{


    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    @Override
    public void init() throws ServletException {
        model= new ReclamoDAO();
    }





}