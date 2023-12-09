package com.example.loginandroid_29_09_2023.mostrarProductos.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.insertarDatosCarrito.view.insertarDatosCarritoView;
import com.example.loginandroid_29_09_2023.mostrarProductos.MostrarProductosInterface;
import com.example.loginandroid_29_09_2023.mostrarProductos.presenter.MostrarProductosPresenter;
import com.example.loginandroid_29_09_2023.restaurant_ventas.view.LstProductsViewUser;

import java.util.ArrayList;

public class MostrarProductosView extends AppCompatActivity implements MostrarProductosInterface.View {


    private RecyclerView recyclerViewProductos;

    private ArrayList<Producto> lstProductos = new ArrayList<>();

    private static MostrarProductosView mainActivity = null;

    private MostrarProductosAdapter adapter;

    private ImageButton btnCarrito;


    private MostrarProductosInterface.Presenter presenter =
            new MostrarProductosPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_carritos);
        mainActivity = this;
        initComponents();

    }

    private void initComponents() {
        recyclerViewProductos = findViewById(R.id.listadeproductos);
        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL, false));
        presenter.login();

        btnCarrito = findViewById(R.id.carrito);
        btnCarrito.setOnClickListener(v -> {


        });
    }

    @Override
    public void success(ArrayList<Producto> lstProductos) {
        this.lstProductos = lstProductos;
        initRecyclerView(this.lstProductos);
    }

    private void initRecyclerView(ArrayList<Producto> lstProductos){
        Intent  intent = getIntent();
        int id_cliente = intent.getIntExtra("clienteId",0);
        System.out.println( "Aqui es donde da por culo id_cliente: " + id_cliente);
        adapter = new MostrarProductosAdapter( lstProductos, this , id_cliente);
        recyclerViewProductos.setAdapter(adapter);
    }

    @Override
    public void failureLogin(String err) {

    }
}
