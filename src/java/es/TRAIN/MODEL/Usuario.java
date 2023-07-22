/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.TRAIN.MODEL;

/**
 *
 * @author MICHAEL
 */
public class Usuario {
    private int id;
    private int idestado;
    private String nombre;
    private String apellido;
    private int dni;

    public Usuario() {
    }

    public Usuario(int id, int idestado, String nombre, String apellido, int dni) {
        this.id = id;
        this.idestado = idestado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    
}
