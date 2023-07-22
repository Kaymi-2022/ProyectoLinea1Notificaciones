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
public class HorarioEstacionesDAO implements DAO<HorarioEstaciones> {

    private Connection con;
    private final ConexionBD cn = new ConexionBD();
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public List<HorarioEstaciones> listar() {
        List<HorarioEstaciones> horario = new ArrayList<>();
        String sql = "SELECT * FROM carreras_estaciones";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HorarioEstaciones h = new HorarioEstaciones();
                h.setId_carrera(rs.getInt(1));
                h.setId_estacion(rs.getInt(2));
                h.setHora_parada(rs.getString(3));
                horario.add(h);
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
        return horario;
    }

    @Override
    public int agregar(HorarioEstaciones h) {
        int rpta = 0;
        String sql = "INSERT INTO carreras_estaciones (carrera_id, estacion_id, horaParada) VALUES (?, ?, ?))";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, h.getId_carrera());
            ps.setInt(2, h.getId_estacion());
            ps.setString(3, h.getHora_parada());
            rpta = ps.executeUpdate();
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException e) {
            }
        }
        return rpta;
    }

    @Override
    public int modificar(HorarioEstaciones h) {
        int res = 0;
        String sql = "UPDATE carreras_estaciones SET horaParada=? WHERE carrera_id=? AND estacion_id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, h.getHora_parada());
            ps.setInt(2, h.getId_carrera());
            ps.setInt(3, h.getId_estacion());
            res = ps.executeUpdate();
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException e) {
            }
        }
        return res;
    }

    @Override
    public int eliminar(HorarioEstaciones h) {
        int rs = 0;
        String sql = "DELETE FROM carreras_estaciones WHERE carrera_id=? AND estacion_id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, h.getId_carrera());
            ps.setInt(2, h.getId_estacion());
            rs = ps.executeUpdate();
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException e) {
            }
        }
        return rs;
    }

}
