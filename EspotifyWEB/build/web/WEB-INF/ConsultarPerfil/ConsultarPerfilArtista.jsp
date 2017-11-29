<%@page import="dataType.DtArtista"%>
<%@page import="clases.Artista"%>
<%@page import="clases.Sistema"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="/Media/estilos/estilos.css" media="screen" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Consultar Perfil</title>
        <style>
            header{
                background: #2c3e50;
                color:#fff;
            }
            footer{
                background: #2c3e50;
                color:#fff;
            }
            .boton{
                background: #79A4CF;
                border: none; /* Remove borders */
                color: white; /* Add a text color */
                padding: 14px 28px; /* Add some padding */
                cursor: pointer; /* Add a pointer cursor on mouse-over */
            }
            .boton:hover{background:#2c3e50 }
        </style>
    </head>
    <body>
        <header>
            <div class="container">
                <h1>Espotify</h1>
            </div>
        </header>
        <div class="container">
            <p><h2>Consultar Perfil</h2><br></p>
            <form method="POST">
                <%DtArtista variable = (DtArtista) request.getSession().getAttribute("usuario_logueado");%>
                <%--<% String dir_img =variable.getFoto(); %>         <p><img src=""></p>--%>
                <p>NICK: <%out.print(variable.getNick());%> </p>
                <p>NOMBRE: <%out.print(variable.getNombre());%></p>
                <p> APELLIDO: <% out.print(variable.getApellido());%> </p>
                <p>WEB: <%out.print(variable.getDireccionWeb());%></p>
                <p>CORREO ELECTRONICO: <% out.print(variable.getEmail());%></p>
                <p>BIOGRAFIA:</n><% out.print(variable.getBiografia());%></p>
                <p>Albumns: <%
                    ArrayList <String> alb = (ArrayList <String>) request.getAttribute("AlbumnesPublicados");
                    Iterator ita = alb.iterator();
                    if(ita.hasNext()){
                        %><select><%
                            String n;
                            while (ita.hasNext()){
                                n = (String) ita.next();
                            %><option><%
                                out.print(n);    
                            %></option>><%
                            }
                        %></select><%
                    }else{
                            String r = "No tiene albumns publicados";
                            out.print(r);  
                        }
                     %>              
                </p>
                <p>Seguidores: <%
                    ArrayList <String> seg = (ArrayList <String>) request.getAttribute("Seguidores");
                    Iterator its = seg.iterator();
                    if(its.hasNext()){
                        %><select><%
                            String s;
                            while (its.hasNext()){
                                s = (String) its.next();
                                %><option><%
                                    out.print(s);    
                                %></option>><%
                            }
                        %></select><%
                    }else{
                        String ret = "No tiene Seguidores";    
                        out.print(ret);  
                        }
                    %>              
                </p>
            </form>
            <form action="Home" method="POST">
                <input type="button" class="boton" value="Volver a inicio" onclick="submit()">
            </form>
        </div>
        <footer>
            <div class="container">
            </div>
        </footer>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    </body>
</html>
