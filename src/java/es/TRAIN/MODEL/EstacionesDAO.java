/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.TRAIN.MODEL;

import es.TRAIN.CONEXION.ConexionBD;
import es.TRAIN.INTERFACE.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MICHAEL
 */
public class EstacionesDAO implements DAO {

    private Connection con;
    private final ConexionBD cn = new ConexionBD();
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public List listar() {
        List<Estaciones> estaciones = new ArrayList<>();
        String sql = "SELECT c.carrera_id,e.nombre, cr.hora_inicio, cr.hora_fin, cr.origen, cr.destino "
                + "FROM carreras_estaciones c JOIN estaciones e JOIN carreras cr ON"
                + " c.estacion_id = e.id AND c.carrera_id = cr.id ORDER BY c.carrera_id";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Estaciones est = new Estaciones();
                est.setId(rs.getInt(1));
                est.setNombre(rs.getString(2));
                est.setCarreras(new Carreras());
                est.getCarreras().setHoraInicio(rs.getString(3));
                est.getCarreras().setHoraFin(rs.getString(4));
                est.getCarreras().setOrigen(rs.getString(5));
                est.getCarreras().setDestino(rs.getString(6));
                estaciones.add(est);
            }
        } catch (SQLException e) {

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
            }
        }
        return estaciones;
    }

    @Override
    public int agregar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int modificar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List listarxId(int id) {
        List<Estaciones> es = new ArrayList<>();
        String sql = "SELECT c.carrera_id, e.nombre FROM carreras_estaciones c JOIN estaciones e ON e.id = c." + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Estaciones c = new Estaciones();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                es.add(c);
            }
        } catch (SQLException e) {

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
            }
        }
        return es;
    }

}
