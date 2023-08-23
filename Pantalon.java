/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciorevision;

/**
 *
 * @author ET36
 */
public class Pantalon extends Producto {

    private String talle;
    private String modelo;

    public Pantalon(String talle, String modelo, String desc, double precio) {
        super(desc, precio);
        this.talle = talle;
        this.modelo = modelo;
    }

    @Override
    public double CalcularPrecio() {

        double precioFinal = 0;
        if ("Oxford".equalsIgnoreCase(modelo)) {
            precioFinal = precio + (precio * 15 / 100);

        } else if ("Skinny".equalsIgnoreCase(modelo)) {
            precioFinal = precio + (precio * 25 / 100);
        } else if ("Recto".equalsIgnoreCase(modelo)) {
            precioFinal = precio - (precio * 15 / 100);
        }

        return precioFinal;
    }

    @Override
    public double getPrecio() {
        // falta invocar al calcularPrecio()
        return precio;
    }

    @Override
    public String toString() {
        // incompleto falta invocar al toString() de producto
        return "talle=" + talle;
    }

}
