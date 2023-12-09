package com.example.loginandroid_29_09_2023.insertarDatosCarrito;

import com.example.loginandroid_29_09_2023.beans.Carrito;
import com.example.loginandroid_29_09_2023.beans.Producto;

import java.util.ArrayList;

public interface insertarDatosCarrito {

    public interface View{
        public void successLogin(Carrito carrito);

        public void successLogin2(ArrayList<Producto> producto);

        void failureLogin(String err);

    }
    public interface Presenter{
        // void login(String email, String pass);
        void login(Carrito carrito);

        void producto(Carrito carrito);
        // void login(ViewUser viewUser);
        // VIEW-ORM
        // BEANS-ENTITIES
        // MVP - MVVM
    }
    public interface Model{
        interface OnLoginUserListener{
            void onFinished(Carrito carrito);

            void onFinished2 (ArrayList<Producto> lstProductos);
            void onFailure(String err);

        }
        void loginAPI(Carrito carrito, OnLoginUserListener onLoginUserListener);

        void productoAPI(Carrito carrito , OnLoginUserListener onLoginUserListener);
    }

}
