<%-- 
    Document   : LoginConductor
    Created on : 6 jul. 2023, 09:37:22
    Author     : MICHAEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Conductor</title>
        <link href="ESTILOS/EstilosLoginConductor.css" rel="stylesheet" type="text/css"/>
        <style>

        </style>
    </head>
    <body>
        <div class="blurred-box">
            <!--  you dont need the user-login-box html  -->
            <!--  for demo purposes only and its shit  -->
            <div class="user-login-box">
                <span class="user-icon"></span>
                <div class="user-name">BINVENIDO CONDUCTOR INGRESE SU CODIGO DE CARRERA</div>
                <form action="./Controlador" method="GET">
                    <input type="hidden" name="realizar" value="VentanaConductor" />
                    <input class="user-password" type="text" name="password" />
                    <br> <br>
                    <button type="submit" style="background-color: red; border: 2px solid black; color: white;">
                        <h2>INGRESAR</h2>
                    </button>
                    <a href="index.html" style="display: inline-block; background-color: red; border: 1px solid black; color: white; text-decoration: none; padding: 2px;">
                        <h2>SALIR</h2>
                    </a>
                </form>
            </div>
        </div>
        <script>
            function link() {
                // Redirigimos a la página "otra_pagina.html" al hacer clic en el botón
                window.location.href = "index.html";
            }
        </script>
    </body>
</html>
