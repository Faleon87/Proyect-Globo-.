package com.example.loginandroid_29_09_2023.beans;

public class ProductoGroup {

    private Producto producto;
    private int count;

    public ProductoGroup(Producto producto) {
        this.producto = producto;
        this.count = 1;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        count++;
    }

    public String getNombre() {
        return producto.getNombre();
    }
}
