/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function llenarFormulario(fila) {
    var codigo = $(fila).find(".Idp").text();
    var nombre = $(fila).find(".pnombre").text();
    var desc = $(fila).find(".pdescrpcion").text();
    var prec = $(fila).find(".preciop").text();
    var stoc = $(fila).find(".stockp").text();

    $("#txtId").val(codigo);
    $("#txtNombre").val(nombre);
    $("#txtPrecio").val(prec);
    $("#txtStock").val(stoc);
    $("#txtDescripcion").val(desc);

}

$(document).ready(function () {
    $('#mydataTable').DataTable();


    $("#exampleModal").on("hidden.bs.modal", function () {
        $('form')[0].reset();
        $("#txtCategoria option[selected]").removeAttr('selected');
    });

    $(document).on('click', '.btnEditar', function () {
        llenarFormulario($(this).closest('tr'));
        $('.btnOcultar1').attr('disabled', 'disabled');
        $('.btnOcultar').removeAttr('disabled');
    });
    $(document).on('click', '.btnEliminar', function () {
        llenarFormulario($(this).closest('tr'));
        $('.btnOcultar1').attr('disabled', 'disabled');
        $('.btnOcultar').removeAttr('disabled');
    });
    $(document).on('click', '.btnAdd', function () {
        $('.btnOcultar').attr('disabled', 'disabled');
        $('.btnOcultar1').removeAttr('disabled');
    });

});


