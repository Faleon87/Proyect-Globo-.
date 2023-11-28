package com.example.loginandroid_29_09_2023.beans;

public class User {
    private String username;
    private String token;
    private Cliente cliente;

    public User(String username, String token, Cliente cliente) {
        this.username = username;
        this.token = token;
        this.cliente = cliente;
    }
    public User(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
