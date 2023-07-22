/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.addEventListener('click', function (event) {
    if (event.target.classList.contains('btnAdd')) {
        LimpiarFormulario();
    }
});
document.addEventListener('click', function (event) {
    if (event.target.classList.contains('btnEliminar')) {
        var fila = event.target.closest('tr');
        llenarFormulario(fila);
    }
});

function llenarFormulario(fila) {

    var id = fila.querySelector(".txtId").textContent;
    var situacion = fila.querySelector(".txtsituacion").textContent;
    var tipo = fila.querySelector(".txtdiscapacidad").textContent;
    var inicio = fila.querySelector(".txtembarque").textContent;
    var parada = fila.querySelector(".txtdesembarque").textContent;
    var carrera = fila.querySelector(".txtIdcarrera").textContent;

    document.getElementById("txtId").value = id;
    document.getElementById("txtsituacion").value = situacion;
    document.getElementById("txttipo").value = tipo;
    document.getElementById("txtembarque").value = inicio;
    document.getElementById("txtdesembarque").value = parada;
    document.getElementById("txtIdcarrera").value = carrera;
    console.log(id);
}


function LimpiarFormulario() {
    document.getElementById("txtId").value = "";
    document.getElementById("txtsituacion").value = "";
    document.getElementById("txtdiscapacidad").value = "";
    document.getElementById("txtembarque").value = "";
    document.getElementById("txtdesembarque").value = "";
    document.getElementById("txtIdcarrera").value = "";
}