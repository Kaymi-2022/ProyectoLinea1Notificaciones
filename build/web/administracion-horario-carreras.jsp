<%-- 
    Document   : administracion-carreras
    Created on : 29 jun. 2023, 04:05:39
    Author     : MICHAEL
--%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>DASBOARD HTML CSS JS</title>

        <!-- FUENTE GOOGLE FONTS : Poppins -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700;800&display=swap"
              rel="stylesheet">
        <link href="ESTILOS/EstiloTabla.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.5/css/jquery.dataTables.css" />

        <!-- DataTable -->
        <link
            rel="stylesheet"
            type="text/css"
            href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap5.min.css"
            />
        <link
            rel="stylesheet"
            type="text/css"
            href="https://cdn.datatables.net/buttons/2.3.3/css/buttons.bootstrap5.min.css"
            />
        <!-- Bootstrap-->
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            />
        <!-- Font Awesome -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
            integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
    </head>

    <body>

        <div class="admin-dashboard">

            <div class="ds-left-menu ">

                <button class="btn-menu">
                    <i class="fa-solid fa-circle-chevron-left"></i>
                </button>

                <div class="ds-perfil">
                    <div class="foto">
                        <img src="IMG/logo.png" alt="">
                    </div>
                    <div class="info-perfil">
                        <h3>Administrador</h3>
                    </div>
                </div>

                <div class="ds-menu">
                    <ul>
                        <!--<li><a href="Administracion-Choferes.jsp"><i class="fa-solid fa-home"></i><span>Home</span></a></li>-->
                        <li><a href="Controlador?realizar=ListarHorarios"><i class="fa-solid fa-train fa-bounce"></i><span>Gestion Horarios</span></a></li>
                        <li><a href="Controlador?realizar=ListarConductores"><i class="fa-sharp fa-solid fa-id-card fa-bounce"></i><span>Gestion Choferes</span></a></li>
                        <li><a href="Controlador?realizar=ListarUsuarios"><i class="fa-sharp fa-solid fa-list-check fa-bounce"></i><span>Gestion Usuarios</span></a></li>
                        <li><a href="Controlador?realizar=ListarEstaciones"><i class="fa-solid fa-clipboard-list"></i><span>Gestion Paradas</span></a></li>
                        <li><a href="Controlador?realizar=ListarPMR"><i class="fa-solid fa-clipboard-list"></i><span>Gestion PMRS</span></a></li>
                    </ul>
                </div>

                <div class="sign-off">
                    <a href="index.html" class="btn-sign-off">
                        <i class="fa-sharp fa-solid fa-walkie-talkie fa-beat-fade"></i>
                        <span>Cerrar Sesión</span>
                    </a>
                </div>


            </div>

            <div class="ds-panel">

                <div class="panel-header d-flex justify-content-between">
                    <div class="icono">
                        <i class="fa-sharp fa-solid fa-walkie-talkie fa-beat-fade"></i>
                    </div>
                    <h2>GESTION PARADAS</h2>
                    <div class="col-3 align-content-center align-content-end">
                        <div class="d-grid gap-2">
                            <button type="button" class="btn btn-success" data-bs-toggle="modal"
                                    data-bs-target="#exampleModal" id="btnAgregar" onclick="limpiarFormularioModal()">Agregar</button>
                        </div>
                    </div>
                </div>

                <div class="ds-panel-content">
                    <div class="container my-5">
                        <div class="row">

                            <table id="example" class="table table-striped" style="width: 100%">
                                <thead>
                                    <tr>
                                        <th>N°</th>
                                        <th>ID CARRERA</th>
                                        <th>ID ESTACION</th>
                                        <th>HORA LLEGADA</th>
                                        <th>Modificar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="h" items="${horarios}" varStatus="loop">
                                        <tr>
                                            <td class="id">${loop.index + 1}</td>
                                            <td class="idcarrera">${h.getId_carrera()}</td>
                                            <td class="situacion">${h.getId_estacion()}</td>
                                            <td class="tipo">${h.getHora_parada()}</td>
                                            <td>
                                                <!-- Agregar atributos data-* para almacenar información -->
                                                <button type="button" class="btn btn-primary botonEditar col-6 mx-auto" data-bs-toggle="modal"
                                                        data-bs-target="#exampleModal" data-idcarrera="${h.getId_carrera()}"
                                                        data-idestacion="${h.getId_estacion()}" data-hora="${h.getHora_parada()}">Editar</button>
                                            </td>
                                            <td>
                                                <!-- Agregar atributos data-* para almacenar información -->
                                                <button type="button" class="btn btn-danger btnEliminar" data-bs-toggle="modal" data-bs-target="#exampleModal"
                                                        data-idcarrera="${h.getId_carrera()}" data-idestacion="${h.getId_estacion()}">Eliminar</button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>

        </div>


        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Datos de los Horarios de Paradas</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="Controlador" method="POST" role="form" enctype="multipart/form-data">
                            <div class="row">
                                <div class="col-6">
                                    <label>ID CARRERA</label>
                                    <input type="text" class="form-control" name="txtIdCarrera" id="txtIdCarrera"
                                           readonly="true">
                                </div>
                            </div><br>
                            <div class="row">
                                <div class="col-6">
                                    <label for="nombre">ID ESTACION</label>
                                    <input type="text" class="form-control" name="txtIdEstacion" id="txtIdEstacion" readonly="true">
                                </div>
                                <div class="col-6">
                                    <label for="apellido">HORA</label>
                                    <input class="form-control" type="text" required placeholder="Hora" name="txtHora" id="txtHora">
                                </div>
                            </div><br>
                            <div class="row">
                                <div class="col-12">
                                    <button type="submit" name="realizar" value="GuardarHora" class="btn btn-success btnOcultar">Guardar</button>
                                    <button type="submit" name="realizar" value="EditarHora" class="btn btn-dark btnOcultar">Editar</button>
                                    <button type="submit" name="realizar" value="EliminarHora" class="btn btn-danger btnOcultar">Eliminar</button>
                                    <button type="button" class="btn btn-info" data-bs-dismiss="modal">Cancelar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="FUNCIONES/active-dashboard.js" type="text/javascript"></script>
        <script src="FUNCIONES/llenado-datos-horarios.js" type="text/javascript"></script>
        <script src="FUNCIONES/tabla.js" type="text/javascript"></script>
        <!-- JQuery -->
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"
            integrity="sha512-STof4xm1wgkfm7heWqFJVn58Hm3EtS31XFaagaa8VMReCXAkQnJZ+jEy8PCC/iT18dFy95WcExNHFTqLyp72eQ=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
        ></script>
        <!-- DataTable -->
        <script
            type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"
        ></script>
        <script
            type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"
        ></script>
        <script
            type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"
        ></script>
        <script
            type="text/javascript"
            src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"
        ></script>
        <script
            type="text/javascript"
            src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap5.min.js"
        ></script>
        <script
            type="text/javascript"
            src="https://cdn.datatables.net/buttons/2.3.3/js/dataTables.buttons.min.js"
        ></script>
        <script
            type="text/javascript"
            src="https://cdn.datatables.net/buttons/2.3.3/js/buttons.bootstrap5.min.js"
        ></script>
        <script
            type="text/javascript"
            src="https://cdn.datatables.net/buttons/2.3.3/js/buttons.html5.min.js"
        ></script>
        <script
            type="text/javascript"
            src="https://cdn.datatables.net/buttons/2.3.3/js/buttons.print.min.js"
        ></script>
        <!-- Bootstrap-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    </body>

</html>

