package Servlets;

import clases.Cliente;
import clases.Fabrica;
import clases.Usuario;
import dataType.DtPertenece;
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
 * @author Leandro
 */
public class ConsultarListaCliente extends HttpServlet {

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
            HttpSession sesion = request.getSession();
            String nick = (String) request.getParameter("Clientes");
            Fabrica fabrica = Fabrica.getInstance();
            Interfaz sistema = fabrica.getInterfaz();
            Usuario u = sistema.buscarUsuario(nick);
            Cliente c = (Cliente) u;
            ArrayList<String> s = c.darListasPersonalizadas();
            sesion.setAttribute("listasper", s);
            sesion.setAttribute("nick", nick);
            request.getRequestDispatcher("/WEB-INF/Consultar Lista/JSPlistasCliente.jsp").forward(request, response);
        // Se crea el datatype y se le pasa a la funcion para que traiga los datos de la lista
        // Tanto el nombre de usuario como el nombre de la lista se traen desde el JSP
//        DtPertenece LR = new DtPertenece(nombreLista, nombreUsuario);
//        sistema.seleccionarListaReproduccion(LR);
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
