/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciorevision;

/**
 *
 * @author ET36
 */
public class Remera extends Producto {

    private String talle;

    public Remera(String talle, String desc, double precio) {
        super(desc, precio);
        this.talle = talle;
    }

    @Override
    public double CalcularPrecio() {
        double precioFinal = 0;
        if (talle.equalsIgnoreCase("s")) {
            double por = (precio / 100) * 5;
            precioFinal = por + precio;
        } else if (talle.equalsIgnoreCase("M")) {
            precioFinal = precio + (precio * 10 / 100);
        } else if (talle.equalsIgnoreCase("X")) {
            precioFinal = precio + (precio * 15 / 100);
        } else {
            precioFinal = precio + (precio * 20 / 100);
        }

        return precioFinal;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "talle:" + talle;
    }

}
