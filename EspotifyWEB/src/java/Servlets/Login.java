package Servlets;

import ControlUsuario.EstadoSesion;
import ControlUsuario.GestorUsuario;
import Excepciones.UsuarioNoEncontrado;
import clases.Artista;
import clases.Cliente;
import clases.Fabrica;
import clases.Usuario;
import dataType.DtArtista;
import dataType.DtCliente;
import interfaz.Interfaz;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Clara
 */

public class Login extends HttpServlet {

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
        HttpSession objSesion = request.getSession();
        EstadoSesion nuevoEstado = null;
        try {
            // Si se guardo un registro del radio registrado el if lo captara
            String invitado = request.getParameter("sesion");
            if (invitado.equals("invitado")) {
                nuevoEstado = EstadoSesion.LOGIN_INVITADO;
                request.getSession().setAttribute("tipo_usuario", "Invitado");
            }
        } catch (NullPointerException e) {
            String mail = request.getParameter("mailnick");
            String pass = request.getParameter("password");
            Fabrica fabrica = Fabrica.getInstance();
            Interfaz sistema = fabrica.getInterfaz();
//            sistema.altaPerfil(new DtCliente("Lea","asd","asd","lea@gmail.com",null,null,"123"));
            Usuario u = (Usuario) sistema.buscarUsuario(mail);
            if (u != null) {
                //Chequea contraseña
                if (!u.getContrasenia().equals(pass)) {
                    nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
                } else {
                    nuevoEstado = EstadoSesion.LOGIN_CORRECTO;
                    //Setea el usuario logeado
                    if(u instanceof Artista){
                        request.getSession().setAttribute("tipo_usuario", "Artista");
                        Artista usr = (Artista) u;
                        DtArtista art = new DtArtista(usr.getNick(), usr.getNombre(), usr.getApellido(), usr.getEmail(), usr.getFechaNacimiento(), null, usr.getBiografia(), usr.getDirWeb(), null, null, usr.getContrasenia());
                        request.getSession().setAttribute("usuario_logueado", art);
                    }
                    else{
                        request.getSession().setAttribute("tipo_usuario", "Cliente");
                        Cliente usr = (Cliente) u;
                        DtCliente cli = new DtCliente(usr.getNick(), usr.getNombre(), usr.getApellido(), usr.getEmail(), usr.getFechaNacimiento(), null, usr.getContrasenia());
                        request.getSession().setAttribute("usuario_logueado", cli);
                    }
                }
            } else {
                nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
            }
        }
        objSesion.setAttribute("estado_sesion", nuevoEstado);
        //Redirige a la pagina principal para que redirija a la pagina que corresponda
        RequestDispatcher dispatcher = request.getRequestDispatcher("Home");
        dispatcher.forward(request, response);
    }
    
    static public Usuario getUsuarioLogueado(HttpServletRequest request) throws UsuarioNoEncontrado{
        return GestorUsuario.getInstance().buscarUsuario((String) request.getSession().getAttribute("usuario_logueado"));
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
