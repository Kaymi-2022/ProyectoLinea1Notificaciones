/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.addEventListener('DOMContentLoaded', function () {
    var btnEditar = document.querySelectorAll('.botonEditar');
    var btnEliminar = document.querySelectorAll('.botonEliminar');
    var btnAgregar = document.getElementById('botonAgregar');

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
    
    btnAgregar.addEventListener('click', function () {
        LimpiarFormularioModal();
    });
});



function LimpiarFormularioModal() {
    var modal = document.getElementById('exampleModal');
    modal.querySelector('#txtId').value = "";
    modal.querySelector('#txtIdEstado').value = "";
    modal.querySelector('#txtNombre').value = "";
    modal.querySelector('#txtApellido').value = "";
    modal.querySelector('#txtDni').value = "";
}

function llenarFormularioModal(btn) {
    var modal = document.getElementById('exampleModal');
    var id = btn.getAttribute('data-id');
    var estado = btn.getAttribute('data-estado');
    var nombre = btn.getAttribute('data-nombre');
    var apellido = btn.getAttribute('data-apellido');
    var dni = btn.getAttribute('data-dni');

    modal.querySelector('#txtId').value = id;
    modal.querySelector('#txtIdEstado').value = estado;
    modal.querySelector('#txtNombre').value = nombre;
    modal.querySelector('#txtApellido').value = apellido;
    modal.querySelector('#txtDni').value = dni;
}