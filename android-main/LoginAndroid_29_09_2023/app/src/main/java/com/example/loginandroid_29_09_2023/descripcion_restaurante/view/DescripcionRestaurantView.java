package com.example.loginandroid_29_09_2023.descripcion_restaurante.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Restaurante;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.descripcion_restaurante.ContractDescripcionRest;
import com.example.loginandroid_29_09_2023.descripcion_restaurante.presenter.DescripcionRestaurantPresenter;
import com.example.loginandroid_29_09_2023.restaurant_puntuacion.view.RestaurantOrderRatingView;

import java.util.ArrayList;

public class DescripcionRestaurantView extends AppCompatActivity implements ContractDescripcionRest.View{

    private ContractDescripcionRest.Presenter presenter =
            new DescripcionRestaurantPresenter(this);

    private static DescripcionRestaurantView mainActivity = null;

    private Restaurante restaurante;

    private ImageButton volver3;

    private RecyclerView recyclerView;

    public static DescripcionRestaurantView getInstance(){
        return mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_rest);
        mainActivity = this;
        initComponents();
    }

    private void initComponents(){

            volver3 = findViewById(R.id.volver3);
            volver3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(DescripcionRestaurantView.this, RestaurantOrderRatingView.class);
                    startActivity(intent);
                }
            });
        Intent intent = getIntent();
        int idRestaurante = intent.getIntExtra("idRestaurante", -1);
        Restaurante restaurante = new Restaurante();
        restaurante.setId_restaurante(idRestaurante);
        recyclerView = findViewById(R.id.listardescripcionRestaurant);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        presenter.login(restaurante);
    }


    @Override
    public void successLogin(Restaurante restaurante) {
    this.restaurante = restaurante;
    initRecyclerView();
    }

    private void initRecyclerView() {
        DescripcionRestaurantAdapter descripcionRestaurantAdapter = new DescripcionRestaurantAdapter(restaurante, this);
        recyclerView.setAdapter(descripcionRestaurantAdapter);
    }

    @Override
    public void failureLogin(String err) {

    }
}

