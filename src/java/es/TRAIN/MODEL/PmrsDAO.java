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
public class PmrsDAO implements DAO<Pmrs> {

    private Connection con;
    private final ConexionBD cn = new ConexionBD();
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public List<Pmrs> listar() {
        List<Pmrs> pmr = new ArrayList<>();
        String sql = "SELECT * FROM pmrs";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pmrs p = new Pmrs();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setTipo(rs.getString(3));
                p.setInicio(rs.getString(4));
                p.setParada(rs.getString(5));
                p.setCarreraID(rs.getInt(6));
                pmr.add(p);
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
        return pmr;
    }

    @Override
    public int agregar(Pmrs p) {
        String sql = "INSERT INTO pmrs(nombre, tipo_pmr, inicio_pmr, fin_pmr, carrera_id) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTipo());
            ps.setString(3, p.getInicio());
            ps.setString(4, p.getParada());
            ps.setInt(5, p.getCarreraID());
            ps.executeUpdate();
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException e) {
            }
        }
        return 1;
    }

    @Override
    public int modificar(Pmrs p) {
        int res = 0;
        String sql = "UPDATE pmrs SET nombre=?,tipo_pmr=?,inicio_pmr=?,fin_pmr=?,carrera_id=? WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTipo());
            ps.setString(3, p.getInicio());
            ps.setString(4, p.getParada());
            ps.setInt(5, p.getCarreraID());
            ps.setInt(6, p.getId());
            res = ps.executeUpdate();
        } catch (Exception e) {
        } finally {
            try {
                con.close();
                ps.close();
            } catch (Exception e) {
            }
        }
        return res;
    }

    @Override
    public int eliminar(Pmrs pmr) {
        int rs = 0;
        String sql = "DELETE FROM pmrs WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pmr.getId());
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

    public List listarNombresEtaciones() {
        List<String> nombres = new ArrayList<>();
        String sql = "SELECT nombre FROM estaciones";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString(1);
                nombres.add(nombre);
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
        return nombres;

    }
}
