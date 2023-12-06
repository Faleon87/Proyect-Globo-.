package com.example.loginandroid_29_09_2023.restaurant_ventas.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.login_user.view.LoginUserM;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.restaurant_puntuacion.view.RestaurantOrderRatingView;
import com.example.loginandroid_29_09_2023.restaurant_ventas.ContractProductUser;
import com.example.loginandroid_29_09_2023.restaurant_ventas.presenter.LstRestVentasPresenter;

import java.util.ArrayList;

public class LstProductsViewUser extends AppCompatActivity implements ContractProductUser.View {

    private LstRestVentasPresenter  lstProductsPresenter;
    private ImageButton volver;
    /* PATRÓN SINGLETON*/
    private ImageButton enviar;
    private RecyclerView recyclerView;
    private ImageButton restaurant;
    private Button order_restaurants_rating_button;
    private ProductoVentasAdapter productoAdapter;

    private ArrayList<ProductRestaurant> ProductoRestaurantes = new ArrayList<>();

    private ArrayList<ProductRestaurant> filterProductRestaurants = new ArrayList<>();

    private static LstProductsViewUser mainActivity = null;


    private TextView american;
    private TextView asian;
    private TextView spain ;
    private TextView italian;


    /* FIN PATRÓN SINGLETON*/


    private LstRestVentasPresenter presenter =
            new LstRestVentasPresenter(this);


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_products_user);
            mainActivity = this;
            initComponents();
        }

    private void initComponents() {
        volver = findViewById(R.id.volver);
       volver.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
               Intent intent = new Intent(LstProductsViewUser.this, LoginUserM.class);
              startActivity(intent);
           }
     });
        order_restaurants_rating_button = findViewById(R.id.order_restaurants_rating_button);
        order_restaurants_rating_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LstProductsViewUser.this, RestaurantOrderRatingView.class);
                startActivity(intent);
            }
        });

        restaurant = findViewById(R.id.restaurant);
        restaurant.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(LstProductsViewUser.this, LstProductsViewUser.class);
                startActivity(intent);
            }
        });

        american = findViewById(R.id.americano);
        american.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                //filterProductRestaurants = ProductoRestaurantes;
                for (int i = 0; i < ProductoRestaurantes.size() ; i++) {
                    if(ProductoRestaurantes.get(i).getRestaurante().getTematica().equals("Americano")){
                        filterProductRestaurants.add(ProductoRestaurantes.get(i));
                    }
                }
                initRecyclerView(filterProductRestaurants);
            }
        });

        italian = findViewById(R.id.italiano);
        italian.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {

            }
        });

        asian = findViewById(R.id.chino);
        asian.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {

            }
        });

        spain = findViewById(R.id.espanol);
        spain.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {

            }
        });




        recyclerView = findViewById(R.id.recyclerView4);
        recyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL, false));

        presenter.lstProductosRest("Ayuda");
    }




    @Override
    public void success(ArrayList<ProductRestaurant> ProductoRestaurantes) {
        this.ProductoRestaurantes = ProductoRestaurantes;
        initRecyclerView(this.ProductoRestaurantes);
    }

    private void initRecyclerView(ArrayList<ProductRestaurant> ProductoRestaurantes) {
        productoAdapter = new ProductoVentasAdapter(ProductoRestaurantes, this);
        recyclerView.setAdapter(productoAdapter);

    }

    @Override
    public void failure(String err) {
        // Lógica de fallo
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }



}
