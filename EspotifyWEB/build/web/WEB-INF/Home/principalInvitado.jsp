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
            <div class="container">
                <section class="main row">
                    <aside class="col-md-10">
                        <h1>Espotify</h1>
                    </aside>
                    <aside class="col-md-2">
                        <ul class="nodomenu">
                            <li>Invitado </li>
                            <li><a href="cerrarSesion">Cerrar sesion</a></li>

                        </ul>
                    </aside>
            </div>
        </header>
        <div class="container-fluid row">

            <div class="navbar menu"> 
                <ul class="nav navbar-nav nodomenu"> 
                    <a href="consultarPerfil"><li>Consultar Perfiles</li></a>
                    <a href="#"><li>Caso de uso 2</li></a>
                    <a href="#"><li>Caso de uso 3</li></a>
                    <a href="#"><li>Caso de uso 4</li></a>
                    <a href="#"><li>Caso de uso 5</li></a>
                    <a href="#"><li>Caso de uso 6</li></a>
                </ul> 
            </div>
            <div class="col-md-1"></div>
            <div class="col-md-11">
                <p> <h1>Entraste como un invitado!</h1> </p>
            </div>
        </div>
    </body>
</html>
