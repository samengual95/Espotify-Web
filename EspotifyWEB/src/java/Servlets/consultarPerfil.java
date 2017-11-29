package Servlets;

/*
 * @author Pc
 */

import static Servlets.Home.getEstado;
import static Servlets.Home.getTipo;
import clases.Artista;
import clases.Cliente;
import clases.Fabrica;
import clases.Usuario;
import dataType.DtArtista;
import dataType.DtCliente;
import interfaz.Interfaz;
import java.util.ArrayList;
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
            Fabrica fabrica = Fabrica.getInstance();
            Interfaz sistema = fabrica.getInterfaz();
            switch(getEstado(request)){
                case NO_LOGIN:
                    request.getRequestDispatcher("/WEB-INF/Home/JSPinicio.jsp").forward(request,response);
                    break;
                case LOGIN_CORRECTO:
                    String variable = (String) objSesion.getAttribute("tipo_usuario");
                    if (variable.equals("Cliente")){
                        DtCliente cl = (DtCliente) request.getSession().getAttribute("usuario_logueado");
                        Cliente c = (Cliente) sistema.buscarUsuario(cl.getNick());
                        request.setAttribute("ListaFavoritos", c.darListasFavoritas());
                        request.setAttribute("AlbumnesFavoritos", c.darAlbumesFavoritos());
                        request.setAttribute("TemasFavoritos", c.darTemasFavoritos());
                        request.setAttribute("Seguidos", c.darSeguidos());
                        request.setAttribute("Seguidores", c.darSeguidores());
                        request.getRequestDispatcher("/WEB-INF/ConsultarPerfil/ConsultarPerfilCliente.jsp").forward(request,response);
                    }
                    if (variable.equals("Artista")){
                        DtArtista art = (DtArtista) request.getSession().getAttribute("usuario_logueado");
                        Artista a = (Artista) sistema.buscarUsuario(art.getNick());
                        request.setAttribute("AlbumnesPublicados", a.darAlbumesPublicados());
                        request.setAttribute("Seguidores", a.darSeguidores());
                        request.getRequestDispatcher("/WEB-INF/ConsultarPerfil/ConsultarPerfilArtista.jsp").forward(request,response);
                    }
                    break;
                case LOGIN_INVITADO:
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
