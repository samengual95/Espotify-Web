package Servlets;

import clases.Fabrica;
import dataType.DtCliente;
import dataType.DtListaReproduccionPersonalizada;
import interfaz.Interfaz;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Clara
 */
public class CrearLista extends HttpServlet {

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
        try{
            HttpSession session = (HttpSession) request.getSession();
            response.setContentType("text/html;charset=UTF-8");
            DtCliente usuario = (DtCliente) session.getAttribute("usuario_logueado");
            String nombre = (String) request.getParameter("nombreLista");
            // Llama a la instancia del sistema
            Interfaz sistema = Fabrica.getInstance().getInterfaz();
            // Crea los datos necesarios para realizar la llamada
            DtListaReproduccionPersonalizada LR = new DtListaReproduccionPersonalizada(nombre, new ArrayList(), usuario.getNick(), false, null);
            // Realiza la llamada a la funcion necesaria 
            sistema.crearListaReproduccion(LR);
            // De ser correcto el caso se redirije a la pagina de caso correcto
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
