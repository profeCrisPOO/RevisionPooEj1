/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ejerciciorevision;

import java.time.LocalDate;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author ET36
 */
public class ShopOnLine {

    public static void main(String[] args) {
        int ingresar = 0;
        Cliente cliente = CrearCliente();
        Venta venta = CrearVenta(cliente);

        HacerCompra(cliente, venta);
        double importe = venta.calcularImporte();
        venta.ImprimirFactura(importe);
        Ingresar(ingresar);

    }

    public static void Ingresar(int ingresar) {
        ingresar = Integer.parseInt(JOptionPane.showInputDialog("2-Desea realizar otra compra- 3 Cerrar cajas"));

        while (ingresar == 2) {
            Cliente cliente1 = CrearCliente();
            Venta venta1 = CrearVenta(cliente1);
            HacerCompra(cliente1, venta1);
            double importe1 = venta1.calcularImporte();
            venta1.ImprimirFactura(importe1);
            ingresar = Integer.parseInt(JOptionPane.showInputDialog("2-Desea realizar otra compra- 3 Cerrar cajas"));

        }

    }

    public static Cliente CrearCliente() {
        String nombre;
        int dni;
        int telefono;
        nombre = JOptionPane.showInputDialog("Ingrese su nombre");
        dni = Integer.parseInt(JOptionPane.showInputDialog("Digite su dni"));
        telefono = Integer.parseInt(JOptionPane.showInputDialog("Digite su numero de telefono"));

        Cliente cliente = new Cliente(nombre, dni, telefono);
        return cliente;
    }

    public static Remera CrearRemera(String talle, double precio, String desc) {
        Remera remera = new Remera(talle, desc, precio);
        return remera;
    }

    public static Pantalon CrearPantalon(String modelo, double precio, String desc, String talle) {
        Pantalon pantalon = new Pantalon(talle, modelo, desc, precio);
        return pantalon;
    }

    public static Accesorio CrearAccesorio(String metal, String desc, double peso) {
        Accesorio accesorio = new Accesorio(peso, metal, desc, peso);
        return accesorio;
    }

    public static Venta CrearVenta(Cliente cliente) {
        LocalDate fecha;
        fecha = LocalDate.now();
        Venta venta = new Venta(fecha, cliente);
        return venta;
    }

    public static double CalcularImporte(Venta venta) {
        double importe = venta.calcularImporte();
        return importe;
    }

    public static void ImprimirFactura(Venta venta, double importe) {
        venta.ImprimirFactura(importe);
    }

    public static void HacerCompra(Cliente cliente, Venta venta) {

        int ingresar = 1;
        int opc = 0;
        String talle;
        double precio;
        String desc;
        double precioFinal = 0;
        while (ingresar == 1) {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Que desea hacer: 1 - Comprar remeras: - 2 Pantalon - 3 Accesorios"));
            switch (opc) {
                case 1:
                    talle = JOptionPane.showInputDialog("Digite el talle de su remera: S-M-L-XL");
                    precio = Double.parseDouble(JOptionPane.showInputDialog("Digite su precio"));
                    desc = JOptionPane.showInputDialog("Diigte la descripcion");

                    Remera remera = CrearRemera(talle, precio, desc);
                    precioFinal = cliente.HacerCompra(remera);
                    remera.setPrecio(precioFinal);
                    venta.agregarProducto(remera);
                     {

                    }
                    break;
                case 2:
                    String modelo = JOptionPane.showInputDialog("Digite el modelo de su pantalon: a - Oxford -b Skinny - c- Recto");
                    talle = JOptionPane.showInputDialog("Digite el talle de su pantalon: S-M-L-XL");
                    precio = Double.parseDouble(JOptionPane.showInputDialog("Digite su precio"));
                    desc = JOptionPane.showInputDialog("Diigte la discripccion");
                    Pantalon p = CrearPantalon(modelo, precio, desc, talle);
                    precioFinal = cliente.HacerCompra(p);
                    p.setPrecio(precioFinal);
                    venta.agregarProducto(p);

                    break;
                case 3:
                    String metal = JOptionPane.showInputDialog("Digite el material del accesorio que desea: 1 Oro, Plata, Acero");
                    desc = JOptionPane.showInputDialog("Diigte la discripccion");

                    double peso = Double.parseDouble(JOptionPane.showInputDialog("Digite el peso del accesorio en KG"));
                    Accesorio accesorio = CrearAccesorio(metal, desc, peso);
                    precioFinal = cliente.HacerCompra(accesorio);
                    accesorio.setPrecio(precioFinal);
                    venta.agregarProducto(accesorio);

                    break;
                default:
                    break;
            }

            ingresar = Integer.parseInt(JOptionPane.showInputDialog("Desea quiere hacer: 1 - Seguir comprando 2 - NO"));
            while (ingresar < 1 || ingresar > 2) {
                JOptionPane.showMessageDialog(null, "Error, ingrese de nuevo");
                ingresar = Integer.parseInt(JOptionPane.showInputDialog("Desea quiere hacer: 1 - Seguir comprando - 2 Realizar otra compra "));

            }

        }

    }

}
