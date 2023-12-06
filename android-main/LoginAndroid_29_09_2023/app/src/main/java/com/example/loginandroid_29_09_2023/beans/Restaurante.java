package com.example.loginandroid_29_09_2023.beans;

public class Restaurante {
    private int id_restaurante;
    private String nombre;
    private String imagen;
    private String descripcion;
    private int ventas;

    private String tematica;

    public Restaurante(int id_restaurante, String nombre, String imagen, String descripcion, int ventas , String tematica) {
        this.id_restaurante = id_restaurante;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.ventas = ventas;
        this.tematica = tematica;
    }
    public Restaurante(){

    }

    public int getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(int id_restaurante) {
        this.id_restaurante = id_restaurante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "id_restaurante=" + id_restaurante +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", ventas=" + ventas +
                ", tematica='" + tematica + '\'' +
                '}';
    }
}
