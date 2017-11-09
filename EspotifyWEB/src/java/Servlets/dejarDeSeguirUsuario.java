/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import clases.Cliente;
import clases.Fabrica;
import clases.Usuario;
import dataType.DtCliente;
import interfaz.Interfaz;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juano
 */

public class dejarDeSeguirUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = (HttpSession) request.getSession();
            Fabrica fabrica = Fabrica.getInstance();
            Interfaz sistema = fabrica.getInterfaz();
            DtCliente cl = (DtCliente) session.getAttribute("usuario_logueado");
            String seguido = (String) request.getParameter("mailnickSeguido");
            Usuario u = sistema.buscarUsuario(cl.getNick());
            if (u == null) 
                request.getRequestDispatcher("/WEB-INF/Paginas de verificacion/JSPerror.jsp").forward(request, response);
            else {
                if (u instanceof Cliente) {
                    sistema.dejarSeguir(u.getNick(), seguido);
                    request.getRequestDispatcher("/WEB-INF/Paginas de verificacion/JSPcorrecto.jsp").forward(request,response);
                } else {
                    request.getRequestDispatcher("/WEB-INF/Paginas de verificacion/JSPerror.jsp").forward(request, response);
                }
            }
            }catch (NullPointerException e) {
            request.getRequestDispatcher("/WEB-INF/Home/JSPinicioErroneo.jsp").forward(request, response);
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
