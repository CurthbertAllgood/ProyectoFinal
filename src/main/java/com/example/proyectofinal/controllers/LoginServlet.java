

//generar Servlets por entidad/vista, no por roles.

//Usar la base de datos para filtrar informacion, no usar variables ni metodos para ese tipo de cosas. Lo que puede resolver la bd lo tiene que hacer la bd




package com.example.proyectofinal.controllers;

import com.example.proyectofinal.modelo.UsuarioDAO;
import com.example.proyectofinal.modelo.Persona;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;

/*
 *
 * @author VGRCAORT
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        try {
            req.getRequestDispatcher("/pages/login.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String userId = request.getParameter("user");
            String password = request.getParameter("password");
            Persona p = new UsuarioDAO().autenticar(userId, password);

            if (p != null) {
                String redirect = request.getParameter("redirect");
                if (redirect != null && !redirect.isEmpty()) {
                    response.sendRedirect(request.getContextPath() + "/" + redirect);
                } else {
                    response.sendRedirect(request.getContextPath() + "/inicio.jsp");
                }
            } else {
                request.setAttribute("hayError", true);
                request.setAttribute("mensajeError", "Credenciales incorrectas!");
                request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("no se genero el objeto", ex);
        } catch (SQLException ex) {
            throw new RuntimeException("error de base de datos", ex);
        }
    }
}

