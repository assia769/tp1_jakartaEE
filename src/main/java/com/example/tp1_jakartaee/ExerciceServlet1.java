package com.example.tp1_jakartaee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ExerciceServlet1", urlPatterns = "/exercice1")
public class ExerciceServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récupérer les paramètres de l'URL
        String nom = request.getParameter("X");
        String age = request.getParameter("Y");

        // Configuration de la réponse
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Exercice 1</title>");
            out.println("<style>");
            out.println("body { font-family: Arial; padding: 50px; background: #f0f0f0; }");
            out.println(".container { background: white; padding: 30px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }");
            out.println("h2 { color: #2c3e50; }");
            out.println(".message { font-size: 20px; color: #27ae60; margin: 20px 0; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h2>Exercice 1 - Résultat</h2>");

            if (nom != null && age != null) {
                out.println("<div class='message'>");
                out.println("<p>Je m'appelle <strong>" + nom + "</strong> et j'ai <strong>" + age + "</strong> ans.</p>");
                out.println("</div>");
            } else {
                out.println("<p style='color: red;'>Erreur : Veuillez fournir les paramètres X (nom) et Y (age) dans l'URL.</p>");
                out.println("<p>Exemple : <code>exercice1?X=Ahmed&Y=20</code></p>");
            }
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}