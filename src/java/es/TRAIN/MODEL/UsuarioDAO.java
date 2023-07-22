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
public class UsuarioDAO implements DAO<Usuario> {

    private Connection con;
    private final ConexionBD cn = new ConexionBD();
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public List<Usuario> listar() {
        List<Usuario> user = new ArrayList<>();
        String sql = "select * from usuario";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt(1));
                u.setIdestado(rs.getInt(2));
                u.setNombre(rs.getString(3));
                u.setApellido(rs.getString(4));
                u.setDni(rs.getInt(5));
                user.add(u);
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
        return user;
    }

    @Override
    public int agregar(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int modificar(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Usuario Validar(int id, int dni) {
        String sql = "select * from usuario where idusuario=? and dni=? and idestado=" + 1;
        Usuario u = new Usuario();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setIdestado(rs.getInt(2));
                u.setNombre(rs.getString(3));
                u.setApellido(rs.getString(4));
                u.setDni(rs.getInt(5));
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
        return u;
    }
}
