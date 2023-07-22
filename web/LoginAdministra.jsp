<%-- 
    Document   : LoginAdministrador
    Created on : 6 jul. 2023, 17:38:41
    Author     : MICHAEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>INICIO SESION ADMIN</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="ESTILOS/stylelogin.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="sweetalert2.min.css">
    </head>
    <body>
        <div class="login-box">
            <h2>Login Administrador</h2>
            <form id="myForm" action="Controlador" method="POST">
                <div class="user-box">
                    <input type="text" name="txtid" required>
                    <label>ID USUARIO</label>
                </div>
                <div class="user-box">
                    <input type="password" name="txtdni" required>
                    <label>DNI</label>
                </div>
                <input type="hidden" name="realizar" value="Validar">
                <a href="#" onclick="submitForm()">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    Ingresar
                </a>
                <a href="index.html">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    Salir
                </a>
            </form>
        </div>
        <script>
            function submitForm() {
                document.getElementById("myForm").submit();
            }

            var message = "<%= request.getAttribute("message")%>";
            if (message >= 0) {
                if (message !== 0) {
                    alert("Usted no esta registrado");
                } else {
                    alert("Bienvenido Usuario");
                }
            }
        </script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.all.min.js"></script>
    </body>
</html>
