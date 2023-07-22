/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.TRAIN.MODEL;

/**
 *
 * @author MICHAEL
 */
public class HorarioEstaciones {
    private int id_carrera;
    private int id_estacion;
    private String hora_parada;

    public HorarioEstaciones(int id_carrera, int id_estacion, String hora_parada) {
        this.id_carrera = id_carrera;
        this.id_estacion = id_estacion;
        this.hora_parada = hora_parada;
    }

    public HorarioEstaciones() {
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public int getId_estacion() {
        return id_estacion;
    }

    public void setId_estacion(int id_estacion) {
        this.id_estacion = id_estacion;
    }

    public String getHora_parada() {
        return hora_parada;
    }

    public void setHora_parada(String hora_parada) {
        this.hora_parada = hora_parada;
    }
}
