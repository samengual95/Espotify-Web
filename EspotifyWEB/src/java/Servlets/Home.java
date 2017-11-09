
package Servlets;

import ControlUsuario.EstadoSesion;
import clases.Fabrica;
import interfaz.Interfaz;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Clara
 */
public class Home extends HttpServlet {

    public static void initSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("estado_sesion") == null){
                session.setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
        }
    }
    public static EstadoSesion getEstado (HttpServletRequest request){
        return (EstadoSesion) request.getSession().getAttribute("estado_sesion");
    }
    public static String getTipo (HttpServletRequest request){
        return (String) request.getSession().getAttribute("tipo_usuario");
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        initSession(request);
        switch(getEstado(request)){
            case NO_LOGIN:
                request.getRequestDispatcher("/WEB-INF/Home/JSPinicio.jsp").forward(request,response);
                break;
            case LOGIN_INCORRECTO:
                request.getRequestDispatcher("/WEB-INF/Home/JSPinicioErroneo.jsp").forward(request,response);
                break;
            case LOGIN_CORRECTO:
                String tipo = getTipo(request);
                if(tipo.equals("Artista"))
                    request.getRequestDispatcher("/WEB-INF/Home/JSPprincipalArtista.jsp").forward(request,response);
                else
                    request.getRequestDispatcher("/WEB-INF/Home/JSPprincipalCliente.jsp").forward(request,response);
                break;
            case LOGIN_INVITADO:
                request.getRequestDispatcher("/WEB-INF/Home/principalInvitado.jsp").forward(request,response);
                break;
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
