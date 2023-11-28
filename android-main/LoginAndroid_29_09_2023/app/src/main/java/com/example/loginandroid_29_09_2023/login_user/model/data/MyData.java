package com.example.loginandroid_29_09_2023.login_user.model.data;

import com.example.loginandroid_29_09_2023.beans.Cliente;
import com.example.loginandroid_29_09_2023.beans.User;

import java.util.ArrayList;

public class MyData {
    private String message;

    private ArrayList<User> lstUsers;

    private ArrayList<Cliente> lstClientes;

    public ArrayList<Cliente> getLstClientes() {
        return lstClientes;
    }

    public void setLstClientes(ArrayList<Cliente> lstClientes) {
        this.lstClientes = lstClientes;
    }

    public String getMessage() {
        return message;
    }
    public ArrayList<User> getLstUsers() {
        return lstUsers;
    }
    public void setLstUsers(ArrayList<User> lstUsers) {
        this.lstUsers = lstUsers;
    }
}

