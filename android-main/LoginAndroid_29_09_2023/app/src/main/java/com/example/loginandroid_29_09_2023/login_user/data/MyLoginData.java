package com.example.loginandroid_29_09_2023.login_user.data;

import com.example.loginandroid_29_09_2023.beans.Cliente;
import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.beans.User;
import com.google.gson.Gson;

import java.util.List;

import kotlin.PropertyReferenceDelegatesKt;

public class  MyLoginData {
    private String message;
    private User user;


    public MyLoginData(String message, User user) {
        this.message = message;
        this.user = user;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "MyLoginData{" +
                "message='" + message + '\'' +
                ", user=" + user +
                '}';
    }
    public static String convertToJson(MyLoginData info) {
        // Crear una instancia de Gson
        Gson gson = new Gson();
        // Convertir el ArrayList de ProductRestaurant a JSON
        return gson.toJson(info);
    }
}

