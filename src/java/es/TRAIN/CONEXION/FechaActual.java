/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.TRAIN.CONEXION;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author MICHAEL
 */
public class FechaActual {

    public String obtenerFechaActual() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = new Date();
        return formatoFecha.format(fecha);
    }

    public static void main(String[] args) {
        FechaActual fecha = new FechaActual();
        System.out.println(fecha.obtenerFechaActual());
    }
}
