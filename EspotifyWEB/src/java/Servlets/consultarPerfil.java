package Servlets;

/*
 * @author Pc
 */

import static Servlets.Home.getEstado;
import static Servlets.Home.getTipo;
import clases.Fabrica;
import clases.Usuario;
import interfaz.Interfaz;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class consultarPerfil extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession objSesion = request.getSession();
        try{
            switch(getEstado(request)){
                case NO_LOGIN:
                    request.getRequestDispatcher("/WEB-INF/Home/JSPinicio.jsp").forward(request,response);
                    break;
                case LOGIN_CORRECTO:
                    String variable = (String) objSesion.getAttribute("tipo_usuario");
                    if (variable.equals("Cliente"))
                        request.getRequestDispatcher("/WEB-INF/ConsultarPerfil/ConsultarPerfilCliente.jsp").forward(request,response);
                    if (variable.equals("Artista"))
                        request.getRequestDispatcher("/WEB-INF/ConsultarPerfil/ConsultarPerfilArtista.jsp").forward(request,response);
                    break;
                case LOGIN_INVITADO:
                    Fabrica fabrica = Fabrica.getInstance();
                    Interfaz sistema = fabrica.getInterfaz();
                    List<Usuario> usrs= (List<Usuario>)sistema.ListaUsuarios();
                    request.setAttribute("usrs", usrs);
                    request.getRequestDispatcher("/WEB-INF/ConsultarPerfil/ConsultarPerfilInvitado.jsp").forward(request,response);
                    break;
            }
        }
        catch (NullPointerException e){
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, 
        HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
}
