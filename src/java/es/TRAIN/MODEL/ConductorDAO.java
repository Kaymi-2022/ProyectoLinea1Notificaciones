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
public class ConductorDAO implements DAO<Conductor> {

    private Connection con;
    private final ConexionBD cn = new ConexionBD();
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public List<Conductor> listar() {
        List<Conductor> cd = new ArrayList<>();
        String sql = "select * from conductores";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Conductor c = new Conductor();
                c.setIdConductor(rs.getInt(1));
                c.setCodigo(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setDNI(rs.getString(4));
                c.setClave(rs.getString(5));
                cd.add(c);
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
        return cd;
    }

    @Override
    public int agregar(Conductor c) {
        int rpta = 0;
        String sql = "INSERT INTO conductores (codigo, nombre,DNI,CLAVE)"
                + "values(?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getCodigo());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDNI());
            ps.setString(4, c.getClave());
            ps.executeUpdate();
            rpta = 1;
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
    public int modificar(Conductor c) {
        int res = 0;
        String sql = "UPDATE cliente SET codigo=?,Nombres=?,DNI=?,clave=? WHERE conductores.id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getCodigo());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDNI());
            ps.setString(4, c.getClave());
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
    public int eliminar(Conductor c) {
        int rs = 0;
        String sql = "DELETE FROM conductores WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getIdConductor());
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

    public Conductor Validar(String codigo, String clave) {
        String sql = "select * from conductores where codigo=? and clave=?";
        Conductor c = new Conductor();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setIdConductor(rs.getInt(1));
                c.setCodigo(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setClave(rs.getString(4));
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
            }
        }
        return c;
    }

}
