package com.example.loginandroid_29_09_2023.beans;

public class Productos {
    private String nombreRestaurante;
    private String nombreProducto;

    private int precio;

    private String imagen;

    private String nombre;

    private int id_restaurante;

    private int id_producto;

    //Constructor

    public Productos(String nombreRestaurante, String nombreProducto, int precio, String imagen, String nombre, int id_restaurante, int id_producto) {
        this.nombreRestaurante = nombreRestaurante;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.imagen = imagen;
        this.nombre = nombre;
        this.id_restaurante = id_restaurante;
        this.id_producto = id_producto;
    }

    public Productos() {
    }


    //Getters y Setters
    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
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

    public int getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(int id_restaurante) {
        this.id_restaurante = id_restaurante;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
}