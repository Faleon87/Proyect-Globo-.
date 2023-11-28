package com.example.loginandroid_29_09_2023.restaurant_puntuacion.view;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.beans.Restaurante;
import com.example.loginandroid_29_09_2023.beans.RestaurantePuntuacion;
import com.example.loginandroid_29_09_2023.restaurant_puntuacion.ContractRestaurantPuntuacion;
import com.example.loginandroid_29_09_2023.restaurant_puntuacion.presenter.RestaurantOrderRatingPresenter;

import java.util.ArrayList;

public class RestaurantOrderRatingView extends AppCompatActivity implements ContractRestaurantPuntuacion.View {

    public static RestaurantOrderRatingView mainActivity = null;

    private RecyclerView recyclerView;

    private ContractRestaurantPuntuacion.Presenter presenter =
            new RestaurantOrderRatingPresenter(this);

    private ArrayList<RestaurantePuntuacion> lstRestaurantsPuntuacion = new ArrayList<>();
    public RestaurantOrderRatingView() {
        mainActivity = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_order_by_rating);
        mainActivity = this;
        initComponents();
    }

    private void initComponents() {
        recyclerView = findViewById(R.id.recyclerView3);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);
        presenter.login();
    }


    @Override
    public void successLogin(ArrayList<RestaurantePuntuacion> lstRestaurantsPuntuacion) {
        this.lstRestaurantsPuntuacion = lstRestaurantsPuntuacion;
        //initRecyclerView();

        LinearLayout linearLayout = findViewById(R.id.lst_restaurants_rating);
        for (RestaurantePuntuacion restaurantePuntuacion : lstRestaurantsPuntuacion) {
            Restaurante restaurante = restaurantePuntuacion.getRestaurante();
            TextView textView = new TextView(this);
            textView.setText(restaurante.getNombre());
            textView.setTextSize(20);
            textView.setHeight(100);
            linearLayout.addView(textView);
        }
    }
    private void initRecyclerView() {
        RestaurantOrderRatingAdapter restaurantOrderRatingAdapter = new RestaurantOrderRatingAdapter(lstRestaurantsPuntuacion, this);
        recyclerView.setAdapter(restaurantOrderRatingAdapter);
    }

    @Override
    public void failureLogin(String err) {

    }
}
