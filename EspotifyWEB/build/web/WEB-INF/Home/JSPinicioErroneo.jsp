<%-- 
    Document   : JSPinicioErroneo
    Created on : 18/10/2017, 06:27:48 PM
    Author     : Clara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        </style>
        <title>Login incorrecto</title>
    </head>
    <body>
        <header>
            <div class="container" text-align:center>
                <h1>Espotify</h1>
            </div>
        </header>
        <div class="container" align="center">
            <table width="280" cellspacing="1" cellpadding="3" border="0" bgcolor="#1E679A"> 
                <tr> 
                    <td><font color="#FFFFFF" face="arial, verdana, helvetica"> 
                        <b>Se ha producido un error!</b> 
                        </font></td> 
                </tr> 
                <tr> 
                    <td bgcolor="#ffffcc"> 
                        <font face="arial, verdana, helvetica"> 
                        Se produjo un error en iniciar sesion o en el registro de un usuario. 
                        </font> 
                    </td> 
                </tr> 
            </table>
        </div>
        <div class="container">
            <section class="main row">
                <aside class="col-md-6">
                    <p><h2>Iniciar sesion</h2><br></p>
                    <form action="Login" method="POST">
                        <p><input type="text" name="mailnick" placeholder="Nickname o email"></p>
                        <p><input type="password" name="password" placeholder="Contraseña"></p>
                        <p><input type="checkbox" name="sesion" value="invitado"> Entrar como invitado</p>
                        <input type="button" class="boton" name="boton1" value="Entrar" onclick="submit()">
                        <input type="reset" class="boton" value="Limpiar formulario">
                    </form>
                </aside>
                <aside class="col-md-6">
                    <p><h2>Registrarse</h2><br></p>
                    <form action="Registrarse" method="POST">
                        <p><input type="text" name="email" placeholder="Email" required></p>
                        <p><input type="text" name="nick" placeholder="Nick" required></p>
                        <p>
                            <label><input type="radio" name="registro" value="artista" required> Artista</label><br>
                            <label><input type="radio" name="registro" value="cliente" required> Cliente</label><br>
                        </p>
                        <p>
                            <input type="button" class="boton" value="Registrar" onclick="submit()">
                            <input type="reset" class="boton" value="Limpiar formulario">
                        </p>
                </aside>
            </section>
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