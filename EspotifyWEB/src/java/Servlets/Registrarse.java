package Servlets;

import clases.Artista;
import clases.Cliente;
import clases.Fabrica;
import clases.Usuario;
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

public class Registrarse extends HttpServlet {

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
        String mail = request.getParameter("email");
        String nick = request.getParameter("nick");
        try {
             Interfaz sistema = Fabrica.getInstance().getInterfaz();
             Usuario u = sistema.buscarUsuario(mail);
             Usuario k = sistema.buscarUsuario(nick);
                if (u == null && k == null){
                    if(request.getParameter("registro").equals("artista")){
//                       Artista ar = new Artista(nick, null, null, mail, null, null, null, null,null);
//                       session.setAttribute("usuario_logueado", ar);
                       session.setAttribute("nick", nick);
                       session.setAttribute("email", mail);
                       session.setAttribute("tipo_usuario", "Artista");
                       request.getRequestDispatcher("/WEB-INF/Home/JSPregistroArtista.jsp").forward(request,response);
                    }else{
//                        Cliente cl = new Cliente(nick, null, null, mail, null, null,null);
//                        session.setAttribute("usuario_logueado", cl);
                        session.setAttribute("nick", nick);
                        session.setAttribute("email", mail);
                        session.setAttribute("tipo_usuario", "Cliente");
                        request.getRequestDispatcher("/WEB-INF/Home/JSPregistroCliente.jsp").forward(request, response);
                    }
                }else 
                    request.getRequestDispatcher("/WEB-INF/Home/JSPinicioErroneo.jsp").forward(request,response);
        } catch(NullPointerException a){
            request.getRequestDispatcher("/WEB-INF/Home/JSPinicioErroneo.jsp").forward(request,response);
        } catch(Exception e){
            request.getRequestDispatcher("/WEB-INF/Home/JSPinicioErroneo.jsp").forward(request,response);
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
