package com.example.tp1_jakartaee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "ExerciceServlet3", urlPatterns = "/exercice3")
public class ExerciceServlet3  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='fr'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Informations Servlet</title>");
            out.println("<style>");
            out.println("body { font-family: 'Courier New', monospace; background: #f5f5f5; padding: 30px; }");
            out.println(".container { background: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); max-width: 1000px; margin: 0 auto; }");
            out.println("h2 { color: #2c3e50; border-bottom: 2px solid #3498db; padding-bottom: 10px; margin-top: 30px; }");
            out.println("h2:first-child { margin-top: 0; }");
            out.println(".info-line { margin: 8px 0; line-height: 1.6; }");
            out.println(".label { color: #2980b9; font-weight: bold; display: inline-block; min-width: 200px; }");
            out.println(".value { color: #27ae60; }");
            out.println(".section { margin-bottom: 25px; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");

            // Request URL Information
            out.println("<div class='section'>");
            out.println("<div class='info-line'>");
            out.println("<span class='label'>requestURL:</span> ");
            out.println("<span class='value'>" + request.getRequestURL() + "</span>");
            out.println("</div>");

            out.println("<div class='info-line'>");
            out.println("<span class='label'>requestURI:</span> ");
            out.println("<span class='value'>" + request.getRequestURI() + "</span>");
            out.println("</div>");

            out.println("<div class='info-line'>");
            out.println("<span class='label'>contextPath:</span> ");
            out.println("<span class='value'>" + request.getContextPath() + "</span>");
            out.println("</div>");

            out.println("<div class='info-line'>");
            out.println("<span class='label'>servletPath:</span> ");
            out.println("<span class='value'>" + request.getServletPath() + "</span>");
            out.println("</div>");

            out.println("<div class='info-line'>");
            out.println("<span class='label'>queryString:</span> ");
            out.println("<span class='value'>" + (request.getQueryString() != null ? request.getQueryString() : "") + "</span>");
            out.println("</div>");
            out.println("</div>");

            // Query Parameters
            if (request.getQueryString() != null) {
                Enumeration<String> paramNames = request.getParameterNames();
                while (paramNames.hasMoreElements()) {
                    String paramName = paramNames.nextElement();
                    out.println("<div class='info-line'>");
                    out.println("<span class='label'>getParameter " + paramName + ":</span> ");
                    out.println("<span class='value'>" + request.getParameter(paramName) + "</span>");
                    out.println("</div>");
                }
            }

            // Server Info
            out.println("<h2>Server info:</h2>");
            out.println("<div class='section'>");
            out.println("<div class='info-line'>");
            out.println("<span class='label'>serverName:</span> ");
            out.println("<span class='value'>" + request.getServerName() + "</span>");
            out.println("</div>");

            out.println("<div class='info-line'>");
            out.println("<span class='label'>serverPort:</span> ");
            out.println("<span class='value'>" + request.getServerPort() + "</span>");
            out.println("</div>");
            out.println("</div>");

            // Client Info
            out.println("<h2>Client info:</h2>");
            out.println("<div class='section'>");
            out.println("<div class='info-line'>");
            out.println("<span class='label'>remoteAddr:</span> ");
            out.println("<span class='value'>" + request.getRemoteAddr() + "</span>");
            out.println("</div>");

            out.println("<div class='info-line'>");
            out.println("<span class='label'>remoteHost:</span> ");
            out.println("<span class='value'>" + request.getRemoteHost() + "</span>");
            out.println("</div>");

            out.println("<div class='info-line'>");
            out.println("<span class='label'>remotePort:</span> ");
            out.println("<span class='value'>" + request.getRemotePort() + "</span>");
            out.println("</div>");

            out.println("<div class='info-line'>");
            out.println("<span class='label'>remoteUser:</span> ");
            out.println("<span class='value'>" + (request.getRemoteUser() != null ? request.getRemoteUser() : "null") + "</span>");
            out.println("</div>");
            out.println("</div>");

            // Headers
            out.println("<h2>headers:</h2>");
            out.println("<div class='section'>");
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                out.println("<div class='info-line'>");
                out.println("<span class='label'>" + headerName + ":</span> ");
                out.println("<span class='value'>" + request.getHeader(headerName) + "</span>");
                out.println("</div>");
            }
            out.println("</div>");

            // Servlet Context Info
            out.println("<h2>Servlet Context info:</h2>");
            out.println("<div class='section'>");
            out.println("<div class='info-line'>");
            out.println("<span class='label'>realPath:</span> ");
            out.println("<span class='value'>" + getServletContext().getRealPath("/") + "</span>");
            out.println("</div>");
            out.println("</div>");

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}