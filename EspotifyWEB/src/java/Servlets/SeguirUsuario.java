/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import clases.Cliente;
import clases.Fabrica;
import clases.Suscripciones;
import clases.Usuario;
import dataType.DtCliente;
import interfaz.Interfaz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MaríaNoel
 */
public class SeguirUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Fabrica fabrica = Fabrica.getInstance();
        Interfaz sistema = fabrica.getInterfaz();
        DtCliente cl = (DtCliente) session.getAttribute("usuario_logueado");
        String seguido = (String) request.getParameter("mailnickSeguido");
        Usuario u = sistema.buscarUsuario(cl.getNick());
        if (u == null) {
            request.getRequestDispatcher("/WEB-INF/Paginas de verificacion/JSPerror.jsp").forward(request, response);
        } else {
            if (u instanceof Cliente) {
                Cliente c = (Cliente) u;
                ArrayList<Suscripciones> l = sistema.listarSuscripciones(c.getNick());
                Suscripciones s;
                Iterator<Suscripciones> it = l.iterator();
                while (it.hasNext()) {
                    s = it.next();
                    if (s.getEstado().equals("Pendiente")) {
                        sistema.seguirUsuario(c.getNick(), seguido);
                        request.getRequestDispatcher("/WEB-INF/Paginas de verificacion/JSPcorrecto.jsp").forward(request, response);
                    }
                }
                request.getRequestDispatcher("/WEB-INF/Paginas de verificacion/JSPerror.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/Paginas de verificacion/JSPerror.jsp").forward(request, response);
            }
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
