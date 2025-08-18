/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventario;

/**
 *
 * @author GEIDG
 */
public class Producto {
    
     private String nombre;
    private String categoria;
    private double precio;
    private int existencias;
    private int unidadesVendidas;
    
        public Producto (String nombre, String categoria, double precio, int existencias, int unidadesVendidas) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.existencias = existencias;
        this.unidadesVendidas = unidadesVendidas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(int unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }
        
        @Override
    public String toString() {
        return nombre + " - " + categoria + " - $" + precio + " - Stock: " + existencias;
    }  
}