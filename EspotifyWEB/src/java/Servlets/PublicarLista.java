package Servlets;

import clases.Fabrica;
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
 * @author Leandro
 */
public class PublicarLista extends HttpServlet {

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
        try {
            // Crea la session y le pide los datos para rellenar la llamada al sistema
            HttpSession session = (HttpSession) request.getSession();
            DtCliente usuario = (DtCliente) session.getAttribute("usuario_logueado");
            String nombre = (String) request.getParameter("nombreListaPublicar");
            // Pide la instancia del sistema
            Interfaz sistema = Fabrica.getInstance().getInterfaz();
            // Hace la llamada a la funcion del sistema
            sistema.hacerPublica(usuario.getNick(), nombre);
            // Redirije a la pagina de que salio todo ¡OK!
            request.getRequestDispatcher("/WEB-INF/Paginas de verificacion/JSPcorrecto.jsp").forward(request,response);
        } catch(Exception e){
            // Si en algun momento salta una exception se redirije a una pagina de error, 
            //  de ser asi se podra agregar mas catch con otros tipos de excepsiones ya que esta es muy general
            request.getRequestDispatcher("/WEB-INF/Paginas de verificacion/JSPerror.jsp").forward(request,response);
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
