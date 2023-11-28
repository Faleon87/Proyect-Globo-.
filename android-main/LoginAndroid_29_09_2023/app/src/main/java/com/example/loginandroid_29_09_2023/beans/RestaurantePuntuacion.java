package com.example.loginandroid_29_09_2023.beans;

public class RestaurantePuntuacion {
    private Restaurante restaurante;
    private Puntuacion puntuacion;

    public RestaurantePuntuacion(Restaurante restaurante, Puntuacion puntuacion) {
        this.restaurante = restaurante;
        this.puntuacion = puntuacion;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Puntuacion getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Puntuacion puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "RestaurantePuntuacion{" +
                "restaurante=" + restaurante +
                ", puntuacion=" + puntuacion +
                '}';
    }
}
