<%@page import="dataType.DtCliente"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="/Media/estilos/estilos.css" media="screen" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>home</title>
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
            .menu{
                background: #2c3e50;
                color: aliceblue;
                position: fixed;
                bottom: 0;
                top: 0;
            }
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
                DtCliente u = (DtCliente) session.getAttribute("usuario_logueado");
                String nick = u.getNick();
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
        <div class="container-fluid row">

            <div class="navbar menu"> 
                <ul class="nav navbar-nav nodomenu"> 
                    <a href="consultarPerfil"><li>Mi perfil</li></a>
                    <a href="direccionarCrearLista"><li>Crear lista reproduccion</li></a>
                    <a href="direccionarAgregarTemaLista"><li>Agregar tema a lista</li></a>
                    <a href="direccionarPublicarLista"><li>Publicar una lista</li></a>
                    <a href="direccionarConsultarLista"><li>Consultar listas</li></a>
                    <a href="direccionarDejarDeSeguirUsuario"><li>Dejar de seguir usuario</li></a>
                    <a href="direccionarGuardarEnFavoritos"><li>Guardar favoritos</li></a>
                    <a href="direccionarSeguirUsuario"><li>Seguir usuario</li></a>
                    <a href="consultaAlbumDir"><li>Consultar Album</li></a>
                    <a href="direccionarContratarSuscripcion"><li>Contratar Suscripcion</li></a>
                    <a href="direccionarActualizarSuscripcion"><li>Actualizar Suscripcion</li></a>
                </ul> 
            </div>
            <div class="col-md-2"></div>
            <div class="col-md-10">
                <p> <h1>Bienvenido <% out.print(nick); %> !!</h1> </p>
            </div>
        </div>
    </body>
</html>
