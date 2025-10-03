package com.example.tp1_jakartaee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ExerciceServlet2", urlPatterns = "/exercice2")
public class ExerciceServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récupérer les données du formulaire
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String genre = request.getParameter("genre");
        String ville = request.getParameter("ville");

        // Configuration de la réponse
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='fr'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Résultat du Formulaire</title>");
            out.println("<style>");
            out.println("body { font-family: 'Segoe UI', sans-serif; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); min-height: 100vh; display: flex; justify-content: center; align-items: center; padding: 20px; }");
            out.println(".container { background: white; padding: 40px; border-radius: 15px; box-shadow: 0 10px 40px rgba(0,0,0,0.2); max-width: 600px; width: 100%; }");
            out.println("h1 { color: #333; text-align: center; margin-bottom: 30px; }");
            out.println(".success-icon { text-align: center; font-size: 60px; margin-bottom: 20px; }");
            out.println(".info-table { width: 100%; border-collapse: collapse; margin: 20px 0; }");
            out.println(".info-table td { padding: 12px; border-bottom: 1px solid #e0e0e0; }");
            out.println(".info-table td:first-child { font-weight: 600; color: #555; width: 40%; }");
            out.println(".info-table td:last-child { color: #333; }");
            out.println(".btn-back { display: block; text-align: center; margin-top: 30px; padding: 12px; background: #667eea; color: white; text-decoration: none; border-radius: 8px; transition: all 0.3s; }");
            out.println(".btn-back:hover { background: #5568d3; transform: translateY(-2px); }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<div class='success-icon'>✅</div>");
            out.println("<h1>Données reçues avec succès !</h1>");
            out.println("<table class='info-table'>");
            out.println("<tr><td>Nom :</td><td>" + (nom != null ? nom : "Non fourni") + "</td></tr>");
            out.println("<tr><td>Prénom :</td><td>" + (prenom != null ? prenom : "Non fourni") + "</td></tr>");
            out.println("<tr><td>Email :</td><td>" + (email != null ? email : "Non fourni") + "</td></tr>");
            out.println("<tr><td>Mot de passe :</td><td>" + (password != null ? "●●●●●●●●" : "Non fourni") + "</td></tr>");
            out.println("<tr><td>Genre :</td><td>" + (genre != null ? genre : "Non fourni") + "</td></tr>");
            out.println("<tr><td>Ville :</td><td>" + (ville != null ? ville : "Non fourni") + "</td></tr>");
            out.println("</table>");
            out.println("<a href='formulaire.html' class='btn-back'>← Retour au formulaire</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h2>Méthode GET non autorisée</h2>");
        out.println("<p>Veuillez utiliser le formulaire pour soumettre les données.</p>");
        out.println("<a href='formulaire.html'>Retour au formulaire</a>");
    }
}