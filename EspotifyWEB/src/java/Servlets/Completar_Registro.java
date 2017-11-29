/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import ControlUsuario.EstadoSesion;
import clases.Artista;
import clases.Cliente;
import clases.Fabrica;
import clases.Usuario;
import dataType.DtArtista;
import dataType.DtCliente;
import interfaz.Interfaz;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MaríaNoel
 */
public class Completar_Registro extends HttpServlet {

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
        HttpSession session = (HttpSession) request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        String mail = (String) session.getAttribute("email");
        String nick = (String) session.getAttribute("nick");
        String contra = request.getParameter("contra");
        String contra1 = request.getParameter("contra1");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String url = request.getParameter("url");
        String biografia = request.getParameter("biografia");
        String fecha = request.getParameter("fecha");        
        File origen= new File (request.getParameter("foto"));
        
        EstadoSesion nuevoEstado = null;
        try {
            if(contra.equals(contra1)){
                Interfaz sistema = Fabrica.getInstance().getInterfaz();
                File destino = new File(sistema.getDestinoFoto() + nick + ".jpg");
                sistema.copiarArchivo(destino.getAbsolutePath(), origen.getAbsolutePath());
                    if(session.getAttribute("tipo_usuario").equals("Artista")){
//                        Artista ar = (Artista) session.getAttribute("usuario_logueado");
//                        ar.setNombre(nombre);
//                        ar.setApellido(apellido);
//                        ar.setFechaNacimiento(fecha);
//                        ar.setBiografia(biografia);
//                        ar.setDirWeb(url);
                       
                        //
                        DtArtista art = new DtArtista(nick, nombre, apellido, mail, fecha, new ArrayList<String>(), biografia, url, new ArrayList<String>(), destino.getAbsolutePath(), contra);
                        sistema.altaPerfil(art);
                        session.setAttribute("usuario_logueado", art);
                        nuevoEstado = EstadoSesion.LOGIN_CORRECTO;  
                    }
                    else{
//                        Cliente cl = (Cliente) session.getAttribute("usuario_logueado");
//                        cl.setNombre(nombre);
//                        cl.setApellido(apellido);
//                        cl.setFechaNacimiento(fecha);
                        //sistema.copiarArchivo(destino, origen);  
                        DtCliente clien = new DtCliente(nick, nombre, apellido, mail, fecha, destino.getAbsolutePath(), contra);
                        sistema.altaPerfil(clien);
                        session.setAttribute("usuario_logueado", clien);
                        nuevoEstado = EstadoSesion.LOGIN_CORRECTO;                    }
            } else 
                request.getRequestDispatcher("/WEB-INF/Home/JSPinicioErroneo.jsp").forward(request,response);
        } catch(Exception e){
            request.getRequestDispatcher("/WEB-INF/Home/JSPinicioErroneo.jsp").forward(request,response);
        }
        session.setAttribute("estado_sesion", nuevoEstado);
        //Redirige a la pagina principal para que redirija a la pagina que corresponda
        RequestDispatcher dispatcher = request.getRequestDispatcher("Home");
        dispatcher.forward(request, response);
        
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
