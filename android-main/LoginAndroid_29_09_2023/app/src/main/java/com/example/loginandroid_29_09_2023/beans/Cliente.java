package com.example.loginandroid_29_09_2023.beans;

import com.google.gson.Gson;

public class Cliente {
    private int id_cliente;
    private int telefono;

    public Cliente(int id_cliente, int telefono) {
        this.id_cliente = id_cliente;
        this.telefono = telefono;
    }
    public Cliente(){

    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id_cliente=" + id_cliente +
                ", telefono=" + telefono +
                '}';
    }
}
