/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function llenarFormulario(fila) {
    var id = $(fila).find(".id").text();
    var codigo = $(fila).find(".cod").text();
    var nombre = $(fila).find(".nom").text();
    var dni = $(fila).find(".dni").text();
    var clave = $(fila).find(".clave").text();

    $("#txtId").val(id);
    $("#txtcod").val(codigo);
    $("#txtnombre").val(nombre);
    $("#txtdni").val(dni);
    $("#txtclave").val(clave);

    console.log(val(id));
}

$(document).ready(function () {
    $('#example').DataTable();


    $("#exampleModal").on("hidden.bs.modal", function () {
        $('form')[0].reset();
        $("#txtCategoria option[selected]").removeAttr('selected');
    });

    $(document).on('click', '.btnAdd', function () {
        $('.btnGuardar').attr('disabled', 'disabled');
        $('.btnEditar').attr('disabled', 'disabled');
        $('.btnEliminar').attr('disabled', 'disabled');
        $('.btnGuardar').removeAttr('disabled');
    });
    $(document).on('click', '.botonEditar', function () {
        $('.btnGuardar').attr('disabled', 'disabled');
        $('.btnEditar').removeAttr('disabled');
        $('.btnEliminar').attr('disabled', 'disabled');
        llenarFormulario($(this).closest('tr'));
    });

    $(document).on('click', '.botonEliminar', function () {
        $('.btnGuardar').attr('disabled', 'disabled');
        $('.btnEditar').attr('disabled', 'disabled');
        $('.btnEliminar').removeAttr('disabled');
        llenarFormulario($(this).closest('tr'));
    });
});
