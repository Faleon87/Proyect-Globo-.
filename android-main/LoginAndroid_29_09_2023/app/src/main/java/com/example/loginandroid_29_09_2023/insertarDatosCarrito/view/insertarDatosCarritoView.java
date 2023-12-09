package com.example.loginandroid_29_09_2023.insertarDatosCarrito.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Carrito;
import com.example.loginandroid_29_09_2023.insertarDatosCarrito.insertarDatosCarrito;
import com.example.loginandroid_29_09_2023.insertarDatosCarrito.presenter.inserDatosPresenter;

import java.util.ArrayList;

public class insertarDatosCarritoView extends AppCompatActivity implements insertarDatosCarrito.View {



    private inserDatosPresenter presenter = new inserDatosPresenter(this);

    private static insertarDatosCarritoView mainActivity = null;

    public static insertarDatosCarritoView getInstance(){
        return mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_carritos);
        mainActivity = this;
        initComponents();
    }

    private void initComponents(){
        Intent intent = getIntent();
        int idProducto = intent.getIntExtra("idProducto", 0);
        int idCliente = intent.getIntExtra("idCliente", 0);
        System.out.println("idProducto: " + idProducto);
        System.out.println("idCliente: " + idCliente);
        Carrito carrito = new Carrito();
        carrito.setId_producto(idProducto);
        carrito.setId_cliente(idCliente);
        presenter.login(carrito);



    }
    @Override
    public void successLogin(Carrito carrito) {
        int idCliente =carrito.getId_cliente();
        System.out.println("idCliente: " + idCliente);
        presenter.producto(carrito);

    }


    @Override
    public void failureLogin(String err) {

    }
}
