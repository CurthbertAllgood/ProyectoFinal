package com.example.proyectofinal.controllers;

import com.example.proyectofinal.modelo.UsuarioDAO;
import com.example.proyectofinal.modelo.Persona;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String userId = request.getParameter("user");
            String password = request.getParameter("password");
            Persona p = new UsuarioDAO().autenticar(userId, password);

            if (p != null) {
                // Iniciar sesión y guardar el usuario autenticado en la sesión
                HttpSession session = request.getSession(true);
                session.setAttribute("userLogueado", p);
                System.out.println("Usuario autenticado: " + p);

                String redirect = request.getParameter("redirect");
                if (redirect != null && !redirect.isEmpty()) {
                    response.sendRedirect(request.getContextPath() + "/" + redirect);
                } else {
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                }
            } else {
                request.setAttribute("hayError", true);
                request.setAttribute("mensajeError", "Credenciales incorrectas!");
                request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error de base de datos", ex);
        }
    }
}
