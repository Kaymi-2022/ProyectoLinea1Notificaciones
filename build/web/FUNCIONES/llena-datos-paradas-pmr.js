/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


document.addEventListener('DOMContentLoaded', function () {
    var btnEliminar = document.querySelectorAll('#example1 .btnEliminar');

    btnEliminar.forEach(function (btn) {
        btn.addEventListener('click', function () {
            llenarFormularioModal(btn);
        });
    });
});

function llenarFormularioModal(btn) {
    var modal = document.getElementById('exampleModal');
    var tr = btn.closest('tr');
    var idCarrera = tr.querySelector('.id').textContent;
    var situacion = tr.querySelector('.situacion').textContent;
    var tipo = tr.querySelector('.tipo').textContent;
    var inicio = tr.querySelector('.inicio').textContent;
    var horaLlegada = tr.querySelector('.parada').textContent;

    modal.querySelector('#txtIdCarrera').value = idCarrera;
    modal.querySelector('#txtsituacion').value = situacion;
    modal.querySelector('#txttipo').value = tipo;
    modal.querySelector('#txtsalida').value = inicio;;
    modal.querySelector('#txtllegada').value = horaLlegada;
}







