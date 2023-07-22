/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.addEventListener('DOMContentLoaded', function () {
    var btnEditar = document.querySelectorAll('.botonEditar');
    var btnEliminar = document.querySelectorAll('.botonEliminar');

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
    var id = btn.getAttribute('data-id');
    var nombre = btn.getAttribute('data-nombre');
    var hinicio = btn.getAttribute('data-hinicio');
    var hfin = btn.getAttribute('data-hfin');
    var salida = btn.getAttribute('data-salida');
    var llegada = btn.getAttribute('data-llegada');

    modal.querySelector('#txtId').value = id;
    modal.querySelector('#txtNombre').value = nombre;
    modal.querySelector('#txtHoraInicio').value = hinicio;
    modal.querySelector('#txtHoraFin').value = hfin;
    modal.querySelector('#txtOrigen').value = salida;
    modal.querySelector('#txtDestino').value = llegada;
}