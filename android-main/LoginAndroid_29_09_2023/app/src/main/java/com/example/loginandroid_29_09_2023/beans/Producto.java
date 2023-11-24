package com.example.loginandroid_29_09_2023.beans;

public class Producto {
    private int id_producto;
    private int id_restauranter;
    private String descripcion;

    private String imagen;

    private String nombre;
    private int precio;

    public Producto(int id_producto, int id_restauranter, String descripcion, String imagen, String nombre, int precio) {
        this.id_producto = id_producto;
        this.id_restauranter = id_restauranter;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
    }

    public  Producto(){

    }
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_restauranter() {
        return id_restauranter;
    }

    public void setId_restauranter(int id_restauranter) {
        this.id_restauranter = id_restauranter;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id_producto=" + id_producto +
                ", id_restauranter=" + id_restauranter +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}