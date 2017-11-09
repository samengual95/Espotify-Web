<%@page import="dataType.DtCliente"%>
<%@page import="dataType.DtArtista"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="./../css/estilos.css" media="screen" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Dejar de seguir</title>
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
            .nodomenu{
                list-style: none;
                padding: 0;
            }
            .nodomenu a li{
                background: #2c3e50;
                padding: 5px;
                margin: 0 0 1px 0;
            }
            .nodomenu a li:hover{
                background: #213141;
            }
            .nodomenu a{
                color: aliceblue;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <header>
            <%
                DtCliente u = (DtCliente) request.getSession().getAttribute("usuario_logueado");
                String nick = u.getNick();
                // Se debera controlar el estado de suscripcion, de ser adecuado se seguira, de lo contrario se debera redirigir 
            %>
            <div class="container">
                <section class="main row">
                    <aside class="col-md-10">
                        <h1>Espotify</h1>
                    </aside>
                    <aside class="col-md-2">
                        <ul class="nodomenu">
                            <a href="consultarPerfil"><li><% out.print(nick); %></li></a>
                            <a href="cerrarSesion"><li>Cerrar sesion</li></a>
                        </ul>
                    </aside>
            </div>
        </header>
        <div class="container">
            <p><h2>Dejar de seguir usuario</h2><br></p>
            <form action="dejarDeSeguirUsuario" method="POST">
                <p><input type="text" name="mailnickSeguido" placeholder="Indique nick o mail del usuario que desea dejar de seguir" required></p>
                <p>
                    <input type="button" class="boton" value="Aceptar" onclick="submit()">
                </p>
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