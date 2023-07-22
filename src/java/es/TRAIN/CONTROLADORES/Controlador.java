/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package es.TRAIN.CONTROLADORES;

import es.TRAIN.CONEXION.FechaActual;
import es.TRAIN.MODEL.ConductorDAO;
import es.TRAIN.MODEL.EstacionesDAO;
import es.TRAIN.MODEL.HorarioEstaciones;
import es.TRAIN.MODEL.HorarioEstacionesDAO;
import es.TRAIN.MODEL.Pmrs;
import es.TRAIN.MODEL.PmrsDAO;
import es.TRAIN.MODEL.Trenes;
import es.TRAIN.MODEL.TrenesDAO;
import es.TRAIN.MODEL.Usuario;
import es.TRAIN.MODEL.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MICHAEL
 */
@MultipartConfig
public class Controlador extends HttpServlet {

    ConductorDAO conductordao = new ConductorDAO();
    EstacionesDAO estacionesdao = new EstacionesDAO();
    TrenesDAO trenedao = new TrenesDAO();
    FechaActual fecha = new FechaActual();
    Trenes trenes = new Trenes();
    Pmrs pmr;
    PmrsDAO pmrdao = new PmrsDAO();
    Usuario usuario = new Usuario();
    UsuarioDAO usuariodao = new UsuarioDAO();
    HorarioEstaciones horario = new HorarioEstaciones();
    HorarioEstacionesDAO horariosdao = new HorarioEstacionesDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String realizar = request.getParameter("realizar");
            switch (realizar) {
                case "EliminarHora" -> {
                    //Captura de datos
                    int id_carrera = Integer.parseInt(request.getParameter("txtIdCarrera"));
                    int id_estacion = Integer.parseInt(request.getParameter("txtIdEstacion"));
                    String hora = request.getParameter("txtHora");
                    horario = new HorarioEstaciones(id_carrera, id_estacion, hora);
                    request.setAttribute("message", horariosdao.eliminar(horario));
                    request.setAttribute("horarios", horariosdao.listar());
                    request.getRequestDispatcher("./administracion-horario-carreras.jsp").forward(request, response);
                    break;
                }
                case "GuardarHora" -> {
                    //Captura de datos
                    int id_carrera = Integer.parseInt(request.getParameter("txtIdCarrera"));
                    int id_estacion = Integer.parseInt(request.getParameter("txtIdEstacion"));
                    String hora = request.getParameter("txtHora");
                    horario = new HorarioEstaciones(id_carrera, id_estacion, hora);
                    request.setAttribute("message", horariosdao.agregar(horario));
                    request.setAttribute("horarios", horariosdao.listar());
                    request.getRequestDispatcher("./administracion-horario-carreras.jsp").forward(request, response);
                    break;
                }
                case "EditarHora" -> {
                    //Captura de datos
                    int id_carrera = Integer.parseInt(request.getParameter("txtIdCarrera"));
                    int id_estacion = Integer.parseInt(request.getParameter("txtIdEstacion"));
                    String hora = request.getParameter("txtHora");
                    horario = new HorarioEstaciones(id_carrera, id_estacion, hora);
                    request.setAttribute("message", horariosdao.modificar(horario));
                    request.setAttribute("horarios", horariosdao.listar());
                    request.getRequestDispatcher("./administracion-horario-carreras.jsp").forward(request, response);
                    break;
                }
                case "Guardarpmr" -> {
                    //Captura de datos
                    String situacion = request.getParameter("txtsituacion");
                    String tipo = request.getParameter("txtdiscapacidad");
                    String inicio = request.getParameter("txtembarque");
                    String parada = request.getParameter("txtdesembarque");
                    int carrera = Integer.parseInt(request.getParameter("txtIdcarrera"));
                    pmr = new Pmrs(situacion, tipo, inicio, parada, carrera);
                    request.setAttribute("message", pmrdao.agregar(pmr));
                    request.setAttribute("pmr", pmrdao.listar());
                    request.getRequestDispatcher("./Administracion-PMR.jsp").forward(request, response);
                    break;
                }
                case "Editarpmr" -> {
                    //Captura de datos
                    int id = Integer.parseInt(request.getParameter("txtId"));
                    String situacion = request.getParameter("txtsituacion");
                    String tipo = request.getParameter("txtdiscapacidad");
                    String inicio = request.getParameter("txtembarque");
                    String parada = request.getParameter("txtdesembarque");
                    int carrera = Integer.parseInt(request.getParameter("txtIdcarrera"));
                    pmr = new Pmrs(id, situacion, tipo, inicio, parada, carrera);
                    request.setAttribute("message", pmrdao.modificar(pmr));
                    request.setAttribute("pmr", pmrdao.listar());
                    request.getRequestDispatcher("./Administracion-PMR.jsp").forward(request, response);
                    break;
                }
                case "Eliminarpmr" -> {
                    //Captura de datos
                    int id = Integer.parseInt(request.getParameter("txtId"));
                    String situacion = request.getParameter("txtsituacion");
                    String tipo = request.getParameter("txtdiscapacidad");
                    String inicio = request.getParameter("txtembarque");
                    String parada = request.getParameter("txtdesembarque");
                    pmr = new Pmrs(id, situacion, tipo, inicio, parada);
                    request.setAttribute("message", pmrdao.eliminar(pmr));
                    request.setAttribute("pmr", pmrdao.listar());
                    request.getRequestDispatcher("./Administracion-PMR.jsp").forward(request, response);
                    break;
                }
                case "ListarHorarios" -> {
                    request.setAttribute("message", "Bienvenido");
                    request.setAttribute("horarios", horariosdao.listar());
                    request.getRequestDispatcher("./administracion-horario-carreras.jsp").forward(request, response);
                    break;
                }
                case "ListarPMR" -> {
                    request.setAttribute("message", "Bienvenido");
                    request.setAttribute("pmr", pmrdao.listar());
                    request.getRequestDispatcher("./Administracion-PMR.jsp").forward(request, response);
                    break;
                }
                case "ListarUsuarios" -> {
                    request.setAttribute("message", "Bienvenido");
                    request.setAttribute("usuarios", usuariodao.listar());
                    request.getRequestDispatcher("./Administracion-Usuarios.jsp").forward(request, response);
                    break;
                }
                case "ListarConductores" -> {
                    request.setAttribute("message", "Bienvenido");
                    request.setAttribute("conductores", conductordao.listar());
                    request.getRequestDispatcher("./Administracion-Choferes.jsp").forward(request, response);
                    break;
                }
                case "ListarEstaciones" -> {
                    request.setAttribute("message", "Bienvenido");
                    request.setAttribute("estaciones", estacionesdao.listar());
                    request.getRequestDispatcher("./Administracion-Carrera-Estaciones.jsp").forward(request, response);
                    break;
                }
                case "EliminarTareaPmr" -> {
                    //Captura de datos
                    int id = Integer.parseInt(request.getParameter("txtId"));
                    String situacion = request.getParameter("txtsituacion");
                    String tipo = request.getParameter("txttipo");
                    String inicio = request.getParameter("txtsalida");
                    String parada = request.getParameter("txtllegada");
                    int idCarrera = Integer.parseInt(request.getParameter("txtIdCarrera"));
                    pmr = new Pmrs(id, situacion, tipo, inicio, parada, idCarrera);
                    if (pmrdao.eliminar(pmr) > 0) {
                        request.setAttribute("message", "Tarea " + id + " realizada");
                    } else {
                        request.setAttribute("message", "No se elimino");
                    }
                    request.setAttribute("fechaactual", fecha.obtenerFechaActual());
                    request.setAttribute("id", idCarrera);
                    request.setAttribute("listarecorrido", trenedao.listarxId(idCarrera));
                    request.setAttribute("pmr", pmrdao.listar());
                    request.getRequestDispatcher("Administracion-Notificaciones.jsp").forward(request, response);
                    break;
                }
                case "VentanaConductor" -> {
                    String idCarrera = request.getParameter("password");
                    int id = Integer.parseInt(request.getParameter("password"));
                    request.setAttribute("fechaactual", fecha.obtenerFechaActual());
                    request.setAttribute("id", idCarrera);
                    request.setAttribute("listarecorrido", trenedao.listarxId(id));
                    request.setAttribute("pmr", pmrdao.listar());
                    request.getRequestDispatcher("Administracion-Notificaciones.jsp").forward(request, response);
                    break;
                }
                case "Validar" -> {
                    int id = Integer.parseInt(request.getParameter("txtid"));
                    int dni = Integer.parseInt(request.getParameter("txtdni"));
                    usuario = usuariodao.Validar(id, dni);
                    if (usuario.getId() != 0) {
                        request.setAttribute("message", 1);
                        request.setAttribute("user", usuario.getNombre());
                        request.setAttribute("usuarios", usuariodao.listar());
                        request.getRequestDispatcher("Administracion-Usuarios.jsp").forward(request, response);
                    } else {
                        request.setAttribute("message", 0);
                        request.getRequestDispatcher("LoginAdministra.jsp").forward(request, response);
                    }
                    break;
                }
                case "llenadoCombobox" -> {
                    request.setAttribute("listaEstaciones", pmrdao.listarNombresEtaciones());
                    request.getRequestDispatcher("FormularioPMR.jsp").forward(request, response);
                    break;
                }
                case "llenarPmr" -> {

                    String nombre = request.getParameter("nombre");
                    String situacion = request.getParameter("situacion");
                    String inicio = request.getParameter("inicio");
                    String parada = request.getParameter("parada");
                    int idCarrera = Integer.parseInt(request.getParameter("idCarrera"));
                    if ((situacion.equals("0") || inicio.equals("0")) || parada.equals("0")) {
                        request.setAttribute("error", "Por favor, llene todos los campos correctamente.");
                    } else {
                        pmr = new Pmrs(nombre, situacion, inicio, parada, idCarrera);
                        request.setAttribute("message", pmrdao.agregar(pmr));
                        request.setAttribute("listaEstaciones", pmrdao.listarNombresEtaciones());
                        request.getRequestDispatcher("FormularioPMR.jsp").forward(request, response);
                    }
                    break;
                }

                default -> {

                }
            }
//            request.setAttribute("conductores", conductordao.listar());
//            request.getRequestDispatcher("/Administracion-Choferes.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Error " + e.getLocalizedMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
