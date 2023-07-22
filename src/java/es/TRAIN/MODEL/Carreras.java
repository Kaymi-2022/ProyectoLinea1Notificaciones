/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.TRAIN.MODEL;

/**
 *
 * @author MICHAEL
 */
public class Carreras {
    private int id;
    private String origen;
    private String destino;
    private String horaInicio;
    private String horaFin;
    private int conductorid;
    private int trenid;

    public Carreras() {
    }

    public Carreras(int id, String origen, String destino, String horaInicio, String horaFin, int conductorid, int trenid) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.conductorid = conductorid;
        this.trenid = trenid;
    }

    public int getTrenid() {
        return trenid;
    }

    public void setTrenid(int trenid) {
        this.trenid = trenid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public int getConductorid() {
        return conductorid;
    }

    public void setConductorid(int conductorid) {
        this.conductorid = conductorid;
    }
    
    
}
