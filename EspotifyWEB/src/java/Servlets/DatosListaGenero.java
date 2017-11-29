package Servlets;

import clases.Fabrica;
import clases.PorDefecto;
import dataType.DtListaReproduccionDefecto;
import interfaz.Interfaz;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * @author Santi
 */

public class DatosListaGenero extends HttpServlet {

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
            String genero = (String) session.getAttribute("generoSeleccionadoConsultarLista");
            String nombreLista = (String) request.getParameter("listaSeleccionada");
            Fabrica fabrica = Fabrica.getInstance();
            Interfaz sistema = fabrica.getInterfaz();
            PorDefecto lista = sistema.seleccionarListaReproduccion(genero, nombreLista);
            session.setAttribute("listasReproduccionSeleccionadaConsultarLista", lista);
            request.getRequestDispatcher("/WEB-INF/Consultar Lista/JSPdatosListaGenero.jsp").forward(request, response);
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
