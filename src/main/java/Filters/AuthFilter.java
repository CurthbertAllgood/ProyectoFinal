package Filters;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/reclamos", "/loggers"})
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false); // Evitar crear una nueva sesión si no existe
        if (session != null && session.getAttribute("userLogueado") != null) {
            System.out.println("Usuario autenticado: " + session.getAttribute("userLogueado"));
            chain.doFilter(request, response); // Ir al siguiente en la cadena de filters
        } else {
            System.out.println("Sesión nula o usuario no autenticado");
            request.setAttribute("hayError", true);
            request.setAttribute("mensajeError", "Hay que autenticarse primero!");
            String origen = httpRequest.getServletPath();
            String queryS = "?origen=" + origen;
            request.getRequestDispatcher("/login" + queryS).forward(request, response);
        }
    }

    @Override
    public void init(FilterConfig fc) throws ServletException {
        // Inicialización del filtro, si es necesario
    }

    @Override
    public void destroy() {
        // Limpieza del filtro, si es necesario
    }
}
