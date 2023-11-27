package com.example.loginandroid_29_09_2023.beans;

public class Puntuacion {

    private int getId_restaurante;
    private int id_puntuacion;
    private int id_restaurante;

    private  int puntuacion;

    private String comentario;
    public Puntuacion() {
    }

    public Puntuacion(int getId_restaurante, int id_puntuacion, int id_restaurante, int puntuacion, String comentario) {
        this.getId_restaurante = getId_restaurante;
        this.id_puntuacion = id_puntuacion;
        this.id_restaurante = id_restaurante;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }

    public int getGetId_restaurante() {
        return getId_restaurante;
    }

    public void setGetId_restaurante(int getId_restaurante) {
        this.getId_restaurante = getId_restaurante;
    }

    public int getId_puntuacion() {
        return id_puntuacion;
    }

    public void setId_puntuacion(int id_puntuacion) {
        this.id_puntuacion = id_puntuacion;
    }

    public int getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(int id_restaurante) {
        this.id_restaurante = id_restaurante;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
}
