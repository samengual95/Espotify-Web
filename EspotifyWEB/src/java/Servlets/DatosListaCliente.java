/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import clases.Cliente;
import clases.Fabrica;
import clases.Personalizada;
import clases.PorDefecto;
import clases.Usuario;
import dataType.DtListaReproduccionPersonalizada;
import interfaz.Interfaz;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Santi
 */
@WebServlet(name = "DatosListaCliente", urlPatterns = {"/DatosListaCliente"})
public class DatosListaCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        try {
            // El JSP listar listas debe pasar a este servlet el nombre de la lista que se quiere consultar
            String lista = (String) request.getParameter("consultarListaCliente");
            String nick = (String) session.getAttribute("nick");
            Fabrica fabrica = Fabrica.getInstance();
            Interfaz sistema = fabrica.getInterfaz();
            Usuario u = sistema.buscarUsuario(nick);
            Cliente c = (Cliente) u;
            Personalizada p = c.darLista1(lista);
            session.setAttribute("listap", p);
            request.getRequestDispatcher("/WEB-INF/Consultar Lista/JSPdatosListaCliente.jsp").forward(request, response);
        } catch (NullPointerException e) {
            request.getRequestDispatcher("/WEB-INF/Paginas de verificacion/JSPerror.jsp").forward(request, response);
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
