/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inventario;

/**
 *
 * @author GEIDG
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    // Método que cumple con el ejercicio
    public void imprimirElectronicaDisponible() {
        productos.stream()
            .filter(p -> p.getCategoria().equalsIgnoreCase("Electrónica"))
            .filter(p -> p.getExistencias() > 0)
            .sorted(Comparator.comparing(Producto::getNombre))
            .forEach(System.out::println);
    }
}
