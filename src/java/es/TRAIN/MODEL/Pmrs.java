/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.TRAIN.MODEL;

/**
 *
 * @author MICHAEL
 */
public class Pmrs {
    private int id;
    private String nombre;
    private String tipo;
    private String inicio;
    private String parada;
    private int carreraID;

    public Pmrs() {
    }

    public Pmrs(String nombre, String tipo, String inicio, String parada, int carreraID) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.inicio = inicio;
        this.parada = parada;
        this.carreraID = carreraID;
    }

    public Pmrs(int id, String nombre, String tipo, String inicio, String parada, int carreraID) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.inicio = inicio;
        this.parada = parada;
        this.carreraID = carreraID;
    }
    public Pmrs(int id, String nombre, String tipo, String inicio, String parada) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.inicio = inicio;
        this.parada = parada;
    }


    public int getCarreraID() {
        return carreraID;
    }

    public void setCarreraID(int carreraID) {
        this.carreraID = carreraID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getParada() {
        return parada;
    }

    public void setParada(String parada) {
        this.parada = parada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
