package com.example.loginandroid_29_09_2023.lst_products.view;

//import static com.example.loginandroid_29_09_2023.R.id.btnEnviar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.loginandroid_29_09_2023.Parte_admin.view.LoginAdminM;
import com.example.loginandroid_29_09_2023.R;

import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.login_user.view.LoginUserM;
import com.example.loginandroid_29_09_2023.lst_products.ContractListMovies;
import com.example.loginandroid_29_09_2023.lst_products.presenter.LstProductsPresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LstProductsActivity extends AppCompatActivity
        implements ContractListMovies.View {

    private LstProductsPresenter lstProductsPresenter;

    private ArrayList<ProductRestaurant> ProductoRestaurantes = new ArrayList<>();
    private ImageButton btnvuelta;

    private RecyclerView recyclerView;
    private ProductoAdapter productoAdapter;

    private static LstProductsActivity lstProductsActivity = null;

    private LstProductsPresenter presenter =
            new LstProductsPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_lst_products);
        } catch (Exception e) {
            e.printStackTrace();
        }
        lstProductsActivity = this;
        initComponents();
    }

    private void initComponents() {
      btnvuelta = findViewById(R.id.imageButton);
      btnvuelta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LstProductsActivity.this, LoginAdminM.class);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        presenter.lstProductos("Ayuda");


    }

    @Override
    public void successMovies(ArrayList<ProductRestaurant> ProductoRestaurantes) {
        this.ProductoRestaurantes = ProductoRestaurantes;
        initRecyclerView();
    }

    private void  initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productoAdapter = new ProductoAdapter(ProductoRestaurantes, this);
        recyclerView.setAdapter(productoAdapter);

    }

    @Override
    public void failureMovies(String err) {

    }
}

