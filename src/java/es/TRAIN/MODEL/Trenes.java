/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.TRAIN.MODEL;

/**
 *
 * @author MICHAEL
 */
public class Trenes {
    private int id;
    private String numerotren;
    private char tipotren;
    private Estaciones estaciones;
    private String timeParada;

    public Trenes() {
    }

    public Trenes(int id, String numerotren, char tipotren, Estaciones estaciones, String timeParada) {
        this.id = id;
        this.numerotren = numerotren;
        this.tipotren = tipotren;
        this.estaciones = estaciones;
        this.timeParada = timeParada;
    }

    public Estaciones getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(Estaciones estaciones) {
        this.estaciones = estaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumerotren() {
        return numerotren;
    }

    public void setNumerotren(String numerotren) {
        this.numerotren = numerotren;
    }

    public char getTipotren() {
        return tipotren;
    }

    public void setTipotren(char tipotren) {
        this.tipotren = tipotren;
    }

    public String getTimeParada() {
        return timeParada;
    }

    public void setTimeParada(String timeParada) {
        this.timeParada = timeParada;
    }
    
    
    
    
}
