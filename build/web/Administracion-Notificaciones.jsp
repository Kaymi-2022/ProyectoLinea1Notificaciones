<%-- 
    Document   : Notificaciones
    Created on : 30 jun. 2023, 19:10:47
    Author     : MICHAEL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="es.TRAIN.CONEXION.FechaActual"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="shortcut icon" href="#" />
        <title>Modulo Conductor</title>
        <link rel="stylesheet" href="sweetalert2.min.css">
        <!-- CSS personalizado -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
            integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link href="ESTILOS/Estiloreloj.css" rel="stylesheet" type="text/css"/>
        <link href="ESTILOS/EstilosMensajeria.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <link href="ESTILOS/main.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <header>
            <div>
                <i class="fa-sharp fa-solid fa-door-open fa-shake" style="color: #00000e;"></i>
                <a style="color: white" href="./index.html"><h3>EXIT</h3></a>
            </div>
            <div class="d-flex align-items-center gap-2 fw-bold">
                <div>HORA :</div>
                <div class="tiempo" id="clock"></div>
            </div>
            <div class="tiempo fw-bold" >
                Fecha: ${fechaactual}
            </div>
        </header>
        <main class="grid-container">
            <div class="header fw-bold">
                <div> ID CARRERA: ${id}</div>

            </div>
            <div class="sidebar">
                <div class="header-table">
                    <div class="logo-table"><i class="fa-solid fa-train-subway fa-beat"></i></div>
                    <div class="logo-table"><i class="fa-regular fa-clock fa-beat"></i></div>
                    <div class="logo-table"><i class="fa-regular fa-clock fa-beat"></i></div>
                </div>
                <!--tabla con DataTables-->
                <div class="row">
                    <div class="col-lg-12">
                        <table id="example2" class="table table-striped" style="width: 100%">
                            <thead>
                                <tr>
                                    <th>N°</th>
                                    <th>ID Carrera</th>
                                    <th>Nombre de Paradas</th>
                                    <th>fecha</th>
                                    <th>Hora de llegada</th>
                                    <th>Nombre de Paradas</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="l" items="${listarecorrido}" varStatus="loop">
                                    <tr>
                                        <td class="id">${loop.index + 1}</td>
                                        <td >${id}</td>
                                        <td>${l.estaciones.nombre}</td>
                                        <td>${fechaactual}</td>
                                        <td>${l.timeParada}</td>
                                        <td>${l.estaciones.nombre}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="main">
                <div class="header-notificaciones align-center">
                    <i class="fa-solid fa-bell fa-bounce"></i>
                    <p style="justify-content: center; align-items: center">Notificaciones</p>
                    <button style="padding: 7px;" id="notificar">
                        Activar...
                    </button>
                </div>
                <div class="body-notificaciones">
                    <table id="example1" class="table table-striped" style="width: 100%">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>SITUACION</th>
                                <th>DISCAPACIDAD</th>
                                <th>ESTACION EMBARQUE</th>
                                <th>ESTACION DESEMBARQUE</th>
                                <th>ID CARRERA</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="p" items="${pmr}" varStatus="loop">
                                <tr>
                                    <td class="txtId">${p.getId()}</td>
                                    <td class="txtsituacion">${p.getNombre()}</td>
                                    <td class="txtdiscapacidad">${p.getTipo()}</td>
                                    <td class="txtembarque">${p.getInicio()}</td>
                                    <td class="txtdesembarque">${p.getParada()}</td>
                                    <td class="txtIdcarrera">${p.getCarreraID()}</td>
                                    <td>
                                        <button type="button" class="btn btn-danger btnEliminar"data-bs-toggle="modal" data-bs-target="#exampleModal">Eliminar</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
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
                            <form action="Controlador" method="POST" role="form" enctype="multipart/form-data">
                                <div class="row">
                                    <div class="col-6">
                                        <label for="codigo">ID</label>
                                        <input type="text" class="form-control" name="txtId" id="txtId"
                                               readonly="true">
                                    </div>
                                    <div class="col-6">
                                        <label for="codigo">ID CARRERA</label>
                                        <input type="text" class="form-control" name="txtIdCarrera" id="txtIdCarrera" value="${id}"
                                               readonly="true">
                                    </div>
                                </div><br>
                                <div class="row">
                                    <div class="col-6">
                                        <label for="situacion">SITUACION</label>
                                        <input class="form-control" type="text" required placeholder="Situacion" name="txtsituacion"
                                               id="txtsituacion">
                                    </div>
                                    <div class="col-6">
                                        <label for="tipo">TIPO</label>
                                        <input class="form-control" type="text" required placeholder="Tipo"
                                               name="txttipo" id="txttipo">
                                    </div>
                                </div><br>
                                <div class="row">
                                    <div class="col-6">
                                        <label for="salida">LUGAR SALIDA</label>
                                        <input class="form-control" type="text" required placeholder="salida" name="txtembarque"
                                               id="txtembarque">
                                    </div>
                                </div><br>
                                <div class="row">
                                    <div class="col-6">
                                        <label for="salida">LUGAR SALIDA</label>
                                        <input class="form-control" type="text" required placeholder="salida" name="txtdesembarque"
                                               id="txtdesembarque">
                                    </div>
                                    <div class="col-6">
                                        <label for="llegada">LUGAR LLEGADA</label>
                                        <input class="form-control" type="text" required placeholder="Direccion"
                                               name="txtIdcarrera" id="txtIdcarrera">
                                    </div>
                                </div><br>
                                <div class="row">
                                    <div class="col-12">
                                        <button type="submit" name="realizar" value="EliminarTareaPmr"
                                                class="btn btn-danger btnEliminar">Eliminar</button>
                                        <button type="button" class="btn btn-info" name="btncerrar"
                                                data-bs-dismiss="modal">Cancelar</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <footer class="footer">
            <div>BIENVENIDO VMA</div>
            <div class="logo"></div>
        </footer>
        <!-- FUENTE GOOGLE FONTS : Poppins -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700;800&display=swap"
              <!-- fUNCION LLENADO mODAL -->
        <script src="./FUNCIONES/llenado-datos-formularios.js" type="text/javascript"></script>
        <!-- Scripts y enlaces a bibliotecas -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap5.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/2.3.3/js/dataTables.buttons.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/2.3.3/js/buttons.bootstrap5.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/2.3.3/js/buttons.html5.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/2.3.3/js/buttons.print.min.js"></script>
        <script src="FUNCIONES/tabla.js"></script>
        <!--Funcion time y alerta para paradas -->
        <script>
            const notificarBtn = document.querySelector('#notificar');
            notificarBtn.addEventListener('click', () => {
                Notification.requestPermission().then(resultado => {
                    console.log('Respuesta: ', resultado);
                });
            });
            function updateClock() {
                var now = new Date();
                var hours = now.getHours();
                var minutes = now.getMinutes();
                var seconds = now.getSeconds();

                // Formateo de horas, minutos y segundos con dos dígitos
                hours = ("0" + hours).slice(-2);
                minutes = ("0" + minutes).slice(-2);
                seconds = ("0" + seconds).slice(-2);

                var time = hours + ":" + minutes + ":" + seconds;

                document.getElementById("clock").textContent = time;

                // Comparar con el valor de timeParada en cada iteración del forEach
            <c:forEach var="l" items="${listarecorrido}">
                var timeParada = "${l.timeParada}";
                if (timeParada === time) {
                    const notificacion = new Notification('Esta es la notificacion', {
                        icon: './IMG/logo.png',
                        body: 'Alerta llegada a la estacion "${l.estaciones.nombre}"',
                        sound: './MP3/notificacion.mp3' // Ruta al archivo de sonido
                    });

                    notificacion.onclick = function () {
                        window.open('http://google.com');
                    };

                }
            </c:forEach>
            }

            // Actualizar el reloj cada segundo
            setInterval(updateClock, 1000);

        </script>

        <%
            if (request.getAttribute("message") != null) {
        %>
        <script>
            $(document).ready(function () {
                Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: '<%= request.getAttribute("message")%>',
                    showConfirmButton: false,
                    timer: 3000
                });
            });
        </script>
        <%
            }
        %>
        <script src="FUNCIONES/main.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.all.min.js"></script>
    </body>

</html>
