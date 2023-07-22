<%-- 
    Document   : FormularioPMR
    Created on : 6 jul. 2023, 18:54:23
    Author     : MICHAEL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Formulario | Registro </title>
        <link href="ESTILOS/EstiloFormulario.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="wrapper">
            <form action="Controlador?realizar=llenarPmr" method="POST">
                <h1>Formulario PMR</h1>
                <hr class="sep"/>
                <div class="group">
                    <input type="text" name="nombre" required="required" /><span class="highlight"></span><span class="bar"></span>
                    <label>Nombre</label>
                </div>
                <div class="group">
                    <label>Situación</label>
                    <br><br>
                    <select name="situacion" id="inputTipo" class="form-select" required>
                        <option value="0">Seleccione una opción</option>
                        <option value="Silla de Ruedas">Silla de Ruedas</option>
                        <option value="Invidente">Invidente</option>
                        <option value="Sordo">Sordo</option>
                    </select>
                </div>
                <div class="group">
                    <label>Inicio</label>
                    <br><br>
                    <select name="inicio" id="inputInicio" class="form-select" required>
                        <option value="0">Seleccione una opción</option>
                        <c:forEach var="e" items="${listaEstaciones}">
                            <option value="${e}">${e}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="group">
                    <label>Parada</label>
                    <br><br>
                    <select name="parada" id="inputParada" class="form-select" required>
                        <option value="0">Seleccione una opción</option>
                        <c:forEach var="e" items="${listaEstaciones}">
                            <option value="${e}">${e}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="group">
                    <input type="text" name="idCarrera" required="required" /><span class="highlight"></span><span class="bar"></span>
                    <label>ID CARRERA</label>
                </div>
                <div class="btn-box">
                    <button class="btn btn-submit" type="submit">Enviar</button>
                    <button class="btn btn-cancel" type="button" onclick="redirectToIndex()">Cancelar</button>
                    <h5>*Servicio de Notificación<span class="emoji">&#x1F609;</span></h5>
                </div>
            </form>

        </div>
        <script>
            function redirectToIndex() {
                window.location.href = "index.html";
            }
            var message = "${message}"; // Obtener el valor del parámetro message del servlet
            if (message !== "") {
                if (message === "1") {
                    alert("Alerta: ¡se Cargo correctamente!");
                } else {
                    alert("Alerta: ¡Error no se cargo su registro!");
                }

            }
        </script>
    </body>
</html>

