/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package Filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
/**
 *
 * @author VGRCAORT
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"/reclamos","/loggers"})
public class AuthFilter implements Filter {



    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        if (session != null && session.getAttribute("userLogueado") != null) {
            chain.doFilter(request, response); // Ir al siguiente en la cadena de filters
        } else {
            request.setAttribute("hayError", true);
            request.setAttribute("mensajeError", "Hay que autenticarse primero!");
            // httpRequest.getServletPath() me trae el servlet/jsp de origen, por ejemplo, "/perfil" o "/restringida"
            String origen = httpRequest.getServletPath();
            // Armo la queryString, por ejemplo, "?origen=/perfil" o "?origen=/restringida"
            String queryS = "?origen=" + origen;
            // Lo mando para el servlet de login con el dato de origen como parámetro
            // "/login?origen=/perfil" o "/login?origen=/restringida"
            request.getRequestDispatcher("/login" + queryS).forward(request, response);

        }



    }

    @Override
    public void init(FilterConfig fc) throws ServletException {

    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }




}