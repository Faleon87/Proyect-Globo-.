package com.example.loginandroid_29_09_2023.mostrarProductos.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.mostrarProductos.MostrarProductosInterface;
import com.example.loginandroid_29_09_2023.mostrarProductos.presenter.MostrarProductosPresenter;

public class MostrarProductosView extends AppCompatActivity implements MostrarProductosInterface.View {


    private RecyclerView recyclerViewProductos;

    private static MostrarProductosView mainActivity = null;

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

        Intent  intent = getIntent();
        int id_cliente = intent.getIntExtra("clienteId",0);
        presenter.login();



    }

    @Override
    public void success() {

    }

    @Override
    public void failureLogin(String err) {

    }
}
