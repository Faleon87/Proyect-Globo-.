package com.example.loginandroid_29_09_2023.restaurant_ventas.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.login_user.view.LoginUserM;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.lst_products.presenter.LstProductsPresenter;
import com.example.loginandroid_29_09_2023.restaurant_ventas.ContractProductUser;
import com.example.loginandroid_29_09_2023.restaurant_ventas.presenter.LstRestVentasPresenter;

import java.util.ArrayList;

public class LstProductsViewUser extends AppCompatActivity implements ContractProductUser.View {

    private LstRestVentasPresenter  lstProductsPresenter;
    private ImageButton volver;
    /* PATRÓN SINGLETON*/

    private ArrayList<ProductRestaurant> ProductoRestaurantes = new ArrayList<>();
    private static LstProductsViewUser mainActivity = null;


    /* FIN PATRÓN SINGLETON*/


    private LstRestVentasPresenter presenter =
            new LstRestVentasPresenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_user);
        mainActivity = this;
        initComponents();
        setupRecyclerView();
    }

    private void initComponents() {
        volver = findViewById(R.id.volver);
        volver.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginUserM.class);
            startActivity(intent);
        });
      presenter.lstProductosRest("");

    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ProductoVentasAdapter productoVentasAdapter = new ProductoVentasAdapter(); // Asegúrate de tener un constructor adecuado para tu adaptador
        recyclerView.setAdapter(productoVentasAdapter);
    }


    @Override
    public void success(ArrayList<ProductRestaurant> ProductoRestaurantes) {

    }

    @Override
    public void failure(String err) {
        // Lógica de fallo
    }


}
