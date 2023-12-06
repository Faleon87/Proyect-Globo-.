package com.example.loginandroid_29_09_2023.beans;

public class RestaurantFilter {

    private Restaurante restaurante;
    private double puntuacion;

    public RestaurantFilter(Restaurante restaurante, double puntuacion) {
        this.restaurante = restaurante;
        this.puntuacion = puntuacion;
    }
    public RestaurantFilter(){
        restaurante= new Restaurante();

    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }
}
