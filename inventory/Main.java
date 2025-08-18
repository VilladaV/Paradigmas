/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventario;

/**
 *
 * @author GEIDG
 */
public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        inventario.agregarProducto(new Producto("Televisor", "Electrónica", 2500.0, 5, 20));
        inventario.agregarProducto(new Producto("Laptop", "Electrónica", 4500.0, 2, 15));
        inventario.agregarProducto(new Producto("Cámara", "Electrónica", 1500.0, 0, 8));
        inventario.agregarProducto(new Producto("Silla", "Hogar", 300.0, 10, 5));

        System.out.println("Productos de Electrónica disponibles:");
        inventario.imprimirElectronicaDisponible();
    }
}
