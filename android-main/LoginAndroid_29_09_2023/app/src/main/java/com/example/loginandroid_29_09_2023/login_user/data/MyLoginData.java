package com.example.loginandroid_29_09_2023.login_user.data;

import com.example.loginandroid_29_09_2023.beans.User;

public class MyLoginData {
    private String message;
    private User user;


    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
