package Servlets;

import clases.Fabrica;
import dataType.DtCliente;
import dataType.DtPertenece;
import interfaz.Interfaz;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * @author Leandro
 */

public class AgregarTemaLista extends HttpServlet {

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
        HttpSession session = (HttpSession) request.getSession();
        try {
            DtCliente usuario = (DtCliente) session.getAttribute("usuario_logueado");
            String nombreLista = request.getParameter("nombreLista");
            String artista = request.getParameter("artista");
            String nombre = request.getParameter("album");
            String tema = request.getParameter("tema");
            if(nombreLista.equals("") || artista.equals("") || nombre.equals("") || tema.equals("")){
                session.setAttribute("mensaje_error", "En este formulario es obligatorio rellenar todos los campos");
                request.getRequestDispatcher("/WEB-INF/Agregar tema Lista/JSPagregarTemaListaAlbumError.jsp").forward(request,response);
            }
            //Se pide la instancia del sistema
            Fabrica fabrica = Fabrica.getInstance();
            Interfaz sistema = fabrica.getInterfaz(); 
            // Se deben crear los campos que llevara la funcion agregarTemaListaPersonalizada
            DtPertenece listaPropietario = new DtPertenece(nombreLista, usuario.getNick()), ruta = new DtPertenece(nombre, artista);
            // Se llama a la funcion agregarTemaListaPersonalizada en el sistema
            sistema.agregarTemaListaPersonalizada(listaPropietario, ruta, Integer.parseInt(tema));
            // Se redirige a la pagina de que la operacion fue correcta que redirije al home
            request.getRequestDispatcher("/WEB-INF/Paginas de verificacion/JSPcorrecto.jsp").forward(request,response);
        } catch(UnsupportedOperationException e){
            session.setAttribute("mensaje_error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/Agregar tema Lista/JSPagregarTemaListaAlbumError.jsp").forward(request,response);
        } catch (Exception  e){
            session.setAttribute("mensaje_error", "El tema ya estaba agregado a la lista!");
            request.getRequestDispatcher("/WEB-INF/Agregar tema Lista/JSPagregarTemaListaAlbumError.jsp").forward(request,response);
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
