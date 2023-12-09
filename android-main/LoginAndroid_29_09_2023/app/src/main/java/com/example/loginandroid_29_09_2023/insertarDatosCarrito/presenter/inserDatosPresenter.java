package com.example.loginandroid_29_09_2023.insertarDatosCarrito.presenter;

import com.example.loginandroid_29_09_2023.beans.Carrito;
import com.example.loginandroid_29_09_2023.insertarDatosCarrito.insertarDatosCarrito;
import com.example.loginandroid_29_09_2023.insertarDatosCarrito.model.inserDatosModel;

import java.util.ArrayList;

public class inserDatosPresenter implements insertarDatosCarrito.Presenter  , insertarDatosCarrito.Model.OnLoginUserListener{

    private insertarDatosCarrito.View vista;

    private insertarDatosCarrito.Model model;

    public inserDatosPresenter(insertarDatosCarrito.View vista){
        this.vista = vista;
        model = new inserDatosModel(this );
    }



    @Override
    public void login(ArrayList<Carrito> lstCarrito) {
        model.loginAPI(lstCarrito,this);
    }

    @Override
    public void onFinished() {

    }

    @Override
    public void onFailure(String err) {

    }
}
