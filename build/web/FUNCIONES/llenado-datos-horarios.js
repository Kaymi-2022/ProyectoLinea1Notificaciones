/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.addEventListener('DOMContentLoaded', function () {
    var btnEditar = document.querySelectorAll('.botonEditar');
    var btnEliminar = document.querySelectorAll('.btnEliminar');

    btnEditar.forEach(function (btn) {
        btn.addEventListener('click', function () {
            llenarFormularioModal(btn);
        });
    });

    btnEliminar.forEach(function (btn) {
        btn.addEventListener('click', function () {
            llenarFormularioModal(btn);
        });
    });

});

function llenarFormularioModal(btn) {
    var modal = document.getElementById('exampleModal');
    var idCarrera = btn.getAttribute('data-idcarrera');
    var idEstacion = btn.getAttribute('data-idestacion');
    var horaLlegada = btn.getAttribute('data-hora');

    modal.querySelector('#txtIdCarrera').value = idCarrera;
    modal.querySelector('#txtIdEstacion').value = idEstacion;
    modal.querySelector('#txtHora').value = horaLlegada;
}

function eliminarFila(btn) {
    var tr = btn.closest('tr');
    tr.remove();
    // Aquí puedes realizar la lógica para eliminar los datos del servidor si es necesario
}

function limpiarFormularioModal() {
    var modal = document.getElementById('exampleModal');
    modal.querySelector('#txtIdCarrera').value = '';
    modal.querySelector('#txtIdEstacion').value = '';
    modal.querySelector('#txtHora').value = '';
    habilitarEdicion();
}

function habilitarEdicion() {
    document.getElementById('txtIdCarrera').removeAttribute('readonly');
    document.getElementById('txtIdEstacion').removeAttribute('readonly');
    document.getElementById('txtHora').removeAttribute('readonly');
}