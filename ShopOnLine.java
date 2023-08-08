/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ejerciciorevision;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ET36
 */
public class ShopOnLine {

    public static void main(String[] args) {
        Cliente cliente = CrearCliente();
        Venta venta = CrearVenta();

        HacerCompra(cliente, venta);
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

    public static Remera CrearRemera(char talle, double precio, String desc) {
        Remera remera = new Remera(talle, desc, precio);
        return remera;
    }

    public static Pantalon CrearPantalon(String modelo, double precio, String desc, char talle) {
        Pantalon pantalon = new Pantalon(talle, modelo, desc, precio);
        return pantalon;
    }

    public static Accesorio CrearAccesorio(String metal, String desc, double peso) {
        Accesorio accesorio = new Accesorio(peso, metal, desc, peso);
        return accesorio;
    }

    public static Venta CrearVenta() {
        LocalDate fecha;
        fecha = LocalDate.now();
        Venta venta = new Venta(fecha);
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
        char talle;
        double precio;
        String desc;
        double precioFinal = 0;
        ArrayList<Object> array = new ArrayList<Object>();
        while (ingresar == 1) {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Que desea hacer: 1 - Comprar remeras: - 2 Pantalon - 3 Accesorios"));
            switch (opc) {
                case 1:
                    talle = JOptionPane.showInputDialog("Digite el talle de su remera: S-M-L-XL").charAt(0);
                    precio = Double.parseDouble(JOptionPane.showInputDialog("Digite su precio"));
                    desc = JOptionPane.showInputDialog("Diigte la discripccion");

                    Remera remera = CrearRemera(talle, precio, desc);
                    precioFinal = cliente.HacerCompra(remera);
                    remera.setPrecio(precioFinal);
                    venta.agregarProducto(remera);
                     {

                    }
                    break;
                case 2:
                    String modelo = JOptionPane.showInputDialog("Digite el modelo de su pantalon: a - Oxford -b Skinny - c- Recto");
                    talle = JOptionPane.showInputDialog("Digite el talle de su pantalon: S-M-L-XL").charAt(0);
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

                    double peso = Double.parseDouble(JOptionPane.showInputDialog("Digite el peso del accesorio"));
                    Accesorio accesorio = CrearAccesorio(metal, desc, peso);
                    precioFinal = cliente.HacerCompra(accesorio);
                    accesorio.setPrecio(precioFinal);
                    venta.agregarProducto(accesorio);

                    break;
                default:
                    break;
            }

            ingresar = Integer.parseInt(JOptionPane.showInputDialog("Desea terminar su compra: 1 No -2 SI"));
            if (ingresar == 2) {
                double importe = CalcularImporte(venta);
                ImprimirFactura(venta, importe);
            }
            while (ingresar < 1 || ingresar > 2) {
                JOptionPane.showMessageDialog(null, "Error, ingrese de nuevo");
                ingresar = Integer.parseInt(JOptionPane.showInputDialog("Desea terminar su compra: 1 No -2 SI"));

            }
        }

    }

}
