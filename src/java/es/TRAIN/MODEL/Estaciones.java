/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.TRAIN.MODEL;

/**
 *
 * @author MICHAEL
 */
public class Estaciones {

    private int id;
    private String nombre;
    private Carreras carreras;

    public Estaciones() {
    }

    public Estaciones(int id, String nombre, Carreras carreras) {
        this.id = id;
        this.nombre = nombre;
        this.carreras = carreras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carreras getCarreras() {
        return carreras;
    }

    public void setCarreras(Carreras carreras) {
        this.carreras = carreras;
    }

}
