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
import clases.Artista;
import clases.Cliente;
import clases.Fabrica;
import clases.Usuario;
import interfaz.Interfaz;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class consultarPerfilComoInvitado extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession objSesion = request.getSession();
        String nick = (String)request.getParameter("ConsultarUsuario");
        Fabrica fabrica = Fabrica.getInstance();
        Interfaz sistema = fabrica.getInterfaz();
        try{            
            Usuario variable= sistema.buscarUsuario(nick);
            request.getSession().setAttribute("User",variable);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EspotifyPersistence");
            EntityManager em = emf.createEntityManager(); 
            javax.persistence.Query q= em.createNativeQuery("SELECT tipo FROM USUARIO WHERE NICKNAME = '" + nick + "'");
            List<String> tipo =  q.getResultList();
            Iterator<String> it = tipo.iterator();
            String t=null;
            if(it.hasNext()){
                t = (String) it.next();
            }
            if ( t.equals("Cliente"))
                request.getRequestDispatcher("/WEB-INF/ConsultarPerfil/ConsultarPerfilComoInvitadoCliente.jsp").forward(request,response);
            else
                request.getRequestDispatcher("/WEB-INF/ConsultarPerfil/ConsultarPerfilComoInvitadoArtista.jsp").forward(request,response);
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