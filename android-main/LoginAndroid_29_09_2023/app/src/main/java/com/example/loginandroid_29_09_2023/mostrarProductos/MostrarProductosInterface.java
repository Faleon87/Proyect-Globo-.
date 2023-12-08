package com.example.loginandroid_29_09_2023.mostrarProductos;

import com.example.loginandroid_29_09_2023.beans.Producto;

import java.util.ArrayList;

public interface MostrarProductosInterface {
    public interface View{
        public void success(ArrayList<Producto> lstProductos);
        void failureLogin(String err);
    }
    public interface Presenter{
        // void login(String email, String pass);
            void login();
    }
    public interface Model{
        interface OnLoginUserListener{
            void onFinished(ArrayList<Producto> lstProductos);
            void onFailure(String err);

        }
        void loginAPI(OnLoginUserListener onLoginUserListener);
    }
}
