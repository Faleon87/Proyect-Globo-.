package com.example.loginandroid_29_09_2023.mostrarProductos.presenter;

import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.mostrarProductos.MostrarProductosInterface;
import com.example.loginandroid_29_09_2023.mostrarProductos.model.MostrarProductosModel;

import java.util.ArrayList;

public class MostrarProductosPresenter implements MostrarProductosInterface.Presenter, MostrarProductosInterface.Model.OnLoginUserListener {


    private MostrarProductosInterface.View vista;
    private MostrarProductosModel  model;

    public MostrarProductosPresenter(MostrarProductosInterface.View vista){
        this.vista = vista;
        model = new MostrarProductosModel(this);
    }
    @Override
    public void login() {
        model.loginAPI(this);
    }



    @Override
    public void onFinished(ArrayList<Producto> lstProductos) {
        vista.success(lstProductos);
    }

    @Override
    public void onFailure(String err) {

    }
}
