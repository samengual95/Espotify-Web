package org.apache.jsp.WEB_002dINF.ConsultarPerfil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dataType.DtCliente;
import clases.Cliente;
import clases.Sistema;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ConsultarPerfilCliente_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css\" integrity=\"sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M\" crossorigin=\"anonymous\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"/Media/estilos/estilos.css\" media=\"screen\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("        <title>Consultar Perfil</title>\r\n");
      out.write("        <style>\r\n");
      out.write("            header{\r\n");
      out.write("                background: #2c3e50;\r\n");
      out.write("                color:#fff;\r\n");
      out.write("            }\r\n");
      out.write("            footer{\r\n");
      out.write("                background: #2c3e50;\r\n");
      out.write("                color:#fff;\r\n");
      out.write("            }\r\n");
      out.write("            .boton{\r\n");
      out.write("                background: #79A4CF;\r\n");
      out.write("                border: none; /* Remove borders */\r\n");
      out.write("                color: white; /* Add a text color */\r\n");
      out.write("                padding: 14px 28px; /* Add some padding */\r\n");
      out.write("                cursor: pointer; /* Add a pointer cursor on mouse-over */\r\n");
      out.write("            }\r\n");
      out.write("            .boton:hover{background:#2c3e50 }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <header>\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <h1>Espotify</h1>\r\n");
      out.write("            </div>\r\n");
      out.write("        </header>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <p><h2>Consultar Perfil</h2><br></p>\r\n");
      out.write("            <form method=\"POST\">   \r\n");
      out.write("                 <p>NICK: ");
 DtCliente variable = (DtCliente) request.getSession().getAttribute("usuario_logueado");
                out.print(variable.getNick()); 
      out.write(" </p>\r\n");
      out.write("                <p>NOMBRE: ");
 out.print(variable.getNombre()); 
      out.write(" </p>\r\n");
      out.write("                <p>APELLIDO ");
 out.print(variable.getApellido()); 
      out.write(" </p>\r\n");
      out.write("                <p>CORREO ELECTRONICO: ");
 out.print(variable.getEmail());
      out.write(" </p>\r\n");
      out.write("                ");
  ArrayList<String> tfav = (ArrayList<String>) request.getAttribute("TemaFavoritos");
      out.write("\r\n");
      out.write("                    ArrayList<String> afav = (ArrayList<String>) request.getAttribute(\"AlbumnesFavoritos\");\r\n");
      out.write("                    \r\n");
      out.write("                    ArrayList<String> Seguidores = (ArrayList<String>) request.getAttribute(\"Seguidores\");\r\n");
      out.write("                    ArrayList<String> lfav = (ArrayList<String>) request.getAttribute(\"ListaFavoritos\");\r\n");
      out.write("                    %>\r\n");
      out.write("                    <p>Seguidos:   \r\n");
      out.write("                         <select> \r\n");
      out.write("                     ");
 ArrayList<String> Seguidos = (ArrayList<String>) request.getAttribute("Seguidos");
                         if (Seguidos != null){
                        Iterator its = Seguidos.iterator();
                        String n;
                        while(its.hasNext()){ 
                           n = (String) its.next();
      out.write("\r\n");
      out.write("                            <option> ");
 out.print(n);
      out.write(" </option> \r\n");
      out.write("                                                      \r\n");
      out.write("                        ");
}
                    } else
      out.write("\r\n");
      out.write("                        <option> ----- </option>     \r\n");
      out.write("                        </select></p>\r\n");
      out.write("            </form>\r\n");
      out.write("            <form action=\"Home\" method=\"POST\">\r\n");
      out.write("                <input type=\"button\" class=\"boton\" value=\"Volver a inicio\" onclick=\"submit()\">\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        <footer>\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </footer>\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js\" integrity=\"sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js\" integrity=\"sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
