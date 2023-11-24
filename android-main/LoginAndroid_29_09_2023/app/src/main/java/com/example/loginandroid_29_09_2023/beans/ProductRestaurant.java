package com.example.loginandroid_29_09_2023.beans;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ProductRestaurant {
    private Producto producto;
    private Restaurante restaurante;

    public ProductRestaurant(Producto producto, Restaurante restaurante) {
        this.producto = producto;
        this.restaurante = restaurante;
    }
    public  ProductRestaurant(){

    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    public String toString() {
        return "ProductRestaurant{" +
                "producto=" + producto +
                ", restaurante=" + restaurante +
                '}';
    }

    public static String convertToJson(ArrayList<ProductRestaurant> info) {
        // Crear una instancia de Gson
        Gson gson = new Gson();
        // Convertir el ArrayList de ProductRestaurant a JSON
        return gson.toJson(info);
    }

}
