/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciorevision;

import java.util.ArrayList;

/**
 *
 * @author ET36
 */
public class Cliente {

    private String nombre;
    private int dni;
    private int telefono;

    public Cliente(String nombre, int dni, int telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public int getTelefono() {
        return telefono;
    }
//  Este método no debería estar en esta clase
    public double HacerCompra(Producto p) {
        double precioFinal = p.CalcularPrecio();

        return precioFinal;
    }

    @Override
    public String toString() {
        return "Cliente" + "nombre=" + nombre + ", dni=" + dni + ", telefono=" + telefono ;
    }

}
