<%-- 
    Document   : Administracion-Usuarios
    Created on : 25 jun. 2023, 02:38:23
    Author     : MICHAEL
--%>
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
                    <h2>GESTION USUARIOS</h2>
                    <div class="col-3 align-content-center align-content-end">
                        <div class="d-grid gap-2">
                            <button type="button" class="btn btn-success btnAgregar" data-bs-toggle="modal"
                                    data-bs-target="#exampleModal" id="botonAgregar">Agregar</button>
                        </div>
                    </div>
                </div>

                <div class="ds-panel-content">
                    <div class="container my-5">
                        <div class="row">
                            <table id="example" class="table table-striped" style="width:100%">
                                <thead>
                                    <tr>
                                        <th>ID USUARIO</th>
                                        <th>ID ESTADO</th>
                                        <th>NOMBRE</th>
                                        <th>APELLIDO</th>
                                        <th>DNI</th>
                                        <th>ACTUALIZAR</th>
                                        <th>BORRAR</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="u" items="${usuarios}">
                                        <tr>
                                            <td class="id">${u.getId()}</td>
                                            <td class="estado">${u.getIdestado()}</td>
                                            <td class="nombre">${u.getNombre()}</td>
                                            <td class="apellido">${u.getApellido()}</td>
                                            <td class="dni">${u.getDni()}</td>
                                            <td
                                                <!-- Agregar atributos data-* para almacenar información -->
                                                <button type="button" class="btn btn-dark botonEditar" data-bs-toggle="modal" data-bs-target="#exampleModal"
                                                    data-id="${u.getId()}" data-estado="${u.getIdestado()}" data-nombre="${u.getNombre()}"
                                                    data-apellido="${u.getApellido()}" data-dni="${u.getDni()}">Editar</button>
                                            </td>
                                            <td>
                                                <!-- Agregar atributos data-* para almacenar información -->
                                                <button type="button" class="btn btn-danger botonEliminar" data-bs-toggle="modal" data-bs-target="#exampleModal"
                                                        data-id="${u.getId()}" data-estado="${u.getIdestado()}" data-nombre="${u.getNombre()}"
                                                        data-apellido="${u.getApellido()}" data-dni="${u.getDni()}">Eliminar</button>
                                            </td>
                                        </tr>
                                    </c:forEach>
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
                        <h5 class="modal-title" id="exampleModalLabel">Datos de los Usuarios</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="" method="POST" method="POST" role="form" enctype="multipart/form-data">
                            <div class="row">
                                <div class="col-6">
                                    <label for="usuario">ID USUARIO</label>
                                    <input type="text" name="txtId" class="form-control" name="txtId" id="txtId" readonly="true">
                                </div>
                            </div><br>
                            <div class="row">
                                <div class="col-6">
                                    <label for="estado">ID ESTADO</label>
                                    <input type="text" readonly="true" class="form-control" name="txtIdEstado" id="txtIdEstado">
                                </div>
                                <div class="col-6">
                                    <label for="nombre">NOMBRE</label>
                                    <input class="form-control" type="text" required placeholder="Nombre" name="txtNombre" id="txtNombre">
                                </div>
                            </div><br>
                            <div class="row">
                                <div class="col-6">
                                    <label for="apellido">APELLIDO</label>
                                    <input class="form-control" type="text" required placeholder="Dni" name="txtApellido" id="txtApellido">
                                </div>
                                <div class="col-6">
                                    <label for="dni">DNI</label>
                                    <input class="form-control" type="text" required placeholder="Dni" name="txtDni" id="txtDni">
                                </div>
                            </div><br>
                            <div class="row">
                                <div class="col-12">
                                    <button type="accion" name="btnGuardar"
                                            class="btn btn-success btnOcultar">Guardar</button>
                                    <button type="accion" name="btnEditar"
                                            class="btn btn-dark btnOcultar">Editar</button>
                                    <button type="accion" name="btnEliminar"
                                            class="btn btn-danger btnOcultar">Eliminar</button>
                                    <button type="button" class="btn btn-info"
                                            data-bs-dismiss="modal">Cancelar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="FUNCIONES/active-dashboard.js" type="text/javascript"></script>
        <script src="FUNCIONES/tabla.js" type="text/javascript"></script>
        <script src="FUNCIONES/llenado-datos-usuarios.js" type="text/javascript"></script>
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