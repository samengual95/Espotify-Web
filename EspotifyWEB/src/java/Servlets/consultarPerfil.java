/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

/**
 *
 * @author Pc
 */

import ControlUsuario.EstadoSesion;
import ControlUsuario.GestorUsuario;
import Excepciones.UsuarioNoEncontrado;
import clases.Artista;
import clases.Cliente;
import clases.Fabrica;
import clases.Usuario;
import interfaz.Interfaz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
            String variable = (String) objSesion.getAttribute("tipo_usuario");
            if (variable.equals("Cliente"))
                request.getRequestDispatcher("/WEB-INF/ConsultarPerfil/ConsultarPerfilCliente.jsp").forward(request,response);
            if (variable.equals("Artista"))
                request.getRequestDispatcher("/WEB-INF/ConsultarPerfil/ConsultarPerfilArtista.jsp").forward(request,response);
            if (variable.equals("Invitado")){
                Fabrica fabrica = Fabrica.getInstance();
                Interfaz sistema = fabrica.getInterfaz();
                List<Usuario> usrs= (List<Usuario>)sistema.ListaUsuarios();
                request.setAttribute("usrs", usrs);
                request.getRequestDispatcher("/WEB-INF/ConsultarPerfil/ConsultarPerfilInvitado.jsp").forward(request,response);
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
