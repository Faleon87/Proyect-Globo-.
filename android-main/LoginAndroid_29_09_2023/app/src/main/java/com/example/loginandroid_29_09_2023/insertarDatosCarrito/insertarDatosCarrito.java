package com.example.loginandroid_29_09_2023.insertarDatosCarrito;

import com.example.loginandroid_29_09_2023.beans.Carrito;

import java.util.ArrayList;

public interface insertarDatosCarrito {

    public interface View{
        public void successLogin();
        void failureLogin(String err);

    }
    public interface Presenter{
        // void login(String email, String pass);
        void login(Carrito carrito);
        // void login(ViewUser viewUser);
        // VIEW-ORM
        // BEANS-ENTITIES
        // MVP - MVVM
    }
    public interface Model{
        interface OnLoginUserListener{
            void onFinished();
            void onFailure(String err);

        }
        void loginAPI(Carrito carrito, OnLoginUserListener onLoginUserListener);
    }

}
