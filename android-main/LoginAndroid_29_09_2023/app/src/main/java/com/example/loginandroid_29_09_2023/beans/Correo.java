package com.example.loginandroid_29_09_2023.beans;

public class Correo {

    private String correo;

    private int id_cliente;

    public Correo(String correo, int id_cliente) {
        this.correo = correo;
        this.id_cliente = id_cliente;
    }

    public Correo(){

    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
}
