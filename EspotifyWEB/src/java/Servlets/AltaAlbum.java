/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import clases.Artista;
import clases.Fabrica;
import clases.Usuario;
import dataType.DtArtista;
import interfaz.Interfaz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MaríaNoel
 */

public class AltaAlbum extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            HttpSession session = request.getSession();
            Fabrica fabrica = Fabrica.getInstance();
            Interfaz sistema = fabrica.getInterfaz();
            DtArtista ar = (DtArtista) session.getAttribute("usuario_logueado");
            String nombreAl = (String) request.getParameter("nombreAlbum");
            session.setAttribute("nombreAlbum", nombreAl);
            String anioCreacionAl = (String) request.getParameter("anioCreacion");
            session.setAttribute("anioCreacion", anioCreacionAl);
            ArrayList<String> variable = sistema.listarGenero();
            session.setAttribute("gen", variable);
            boolean verificar = sistema.verificarArtista(ar.getNick(), nombreAl);
            if (verificar)
                request.getRequestDispatcher("/WEB-INF/AltaAlbum/JSPgenerosAlbum.jsp").forward(request,response);
            else
                request.getRequestDispatcher("/WEB-INF/Paginas de verificacion/JSPerrorArtista.jsp").forward(request,response);
            } catch (NullPointerException e) {
                    request.getRequestDispatcher("/WEB-INF/Paginas de verificacion/JSPerrorArtista.jsp").forward(request,response);
            }

    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
