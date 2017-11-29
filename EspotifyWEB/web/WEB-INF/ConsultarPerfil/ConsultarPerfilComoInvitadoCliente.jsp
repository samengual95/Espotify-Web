<%@page import="dataType.DtCliente"%>
<%@page import="clases.Cliente"%>
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
                    <p>NICK: <% Cliente variable = (Cliente) request.getSession().getAttribute("User");
                        out.print(variable.getNick());%> </p>
                <p>NOMBRE: <%out.print(variable.getNombre());%></p>
                <p> APELLIDO <% out.print(variable.getApellido());%> </p>
                <p>CORREO ELECTRONICO: <% out.print(variable.getEmail());%> </p>
                <p>Seguidos:   
                     <% ArrayList <String> Seguidos = (ArrayList <String>) request.getAttribute("Seguidos");
                     Iterator <String> its = Seguidos.iterator();   
                     if (its.hasNext()){    
                          %> <select>  <%                        
                            String n;
                            while(its.hasNext()){ 
                               n = its.next();
                    %><option><% out.print(n);%></option><% 
                            }
                    %> </select>  <%                        
                        }
                        else{
                          String s = "No sigues a nadie";
                            out.print(s);         
                          } %>
                         </p>                        
                        <p>Seguidores:
                        <% ArrayList <String> Seguidores = (ArrayList <String>) request.getAttribute("Seguidores");
                        Iterator <String> itss = Seguidores.iterator(); 
                        if (itss.hasNext()){
                             %> <select>  <%
                        String n;
                        while(itss.hasNext()){ 
                            %> <option> <%                       
                           n = itss.next();
                           out.print(n);                                                     
                         %> </option> <% } %>
                             </select>  <% 
                    } else{
                        String n = "No tienes siguidores";
                        out.print(n);
                        }%>
                        </p>
                       <p>Temas Favoritos:   
                     <% ArrayList <String> tfav = (ArrayList <String>) request.getAttribute("TemasFavoritos");
                     Iterator <String> itt = tfav.iterator();   
                     if (itt.hasNext()){    
                          %> <select>  <%                        
                            String n;
                            while(itt.hasNext()){ 
                               n = itt.next();
                    %><option><% out.print(n);%></option><% 
                            }
                    %> </select>  <%                        
                        }
                        else{
                          String s = "No tienes temas favoritos";
                            out.print(s);         
                          } %>
                         </p>
                         <p>Albums Favoritos:   
                     <% ArrayList<String> afav = (ArrayList<String>) request.getAttribute("AlbumnesFavoritos");                    
                     Iterator <String> ita = afav.iterator();   
                     if (ita.hasNext()){    
                          %> <select>  <%                        
                            String n;
                            while(ita.hasNext()){ 
                               n = ita.next();
                    %><option><% out.print(n);%></option><% 
                            }
                    %> </select>  <%                        
                        }
                        else{
                          String s = "No tienes Album favoritos";
                            out.print(s);         
                          } %>
                         </p>
                         <p>Listas Favoritas:
                         <% ArrayList <String> lfav = (ArrayList <String>) request.getAttribute("ListaFavoritos");                    
                     Iterator <String> itl = lfav.iterator();   
                     if (itl.hasNext()){    
                          %> <select>  <%                        
                            String n;
                            while(itl.hasNext()){ 
                               n = itl.next();
                    %><option><% out.print(n);%></option><% 
                            }
                    %> </select>  <%                        
                        }
                        else{
                          String s = "No tienes Album favoritos";
                            out.print(s);         
                          } %>
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
