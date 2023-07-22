/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.TRAIN.INTERFACE;

import java.util.List;

/**
 *
 * @author MICHAEL
 * @param <T>
 */
public interface DAO<T> {
    
    List<T> listar();
    int agregar(T objeto);
    int modificar(T objeto);
    int eliminar(T objeto);
}
