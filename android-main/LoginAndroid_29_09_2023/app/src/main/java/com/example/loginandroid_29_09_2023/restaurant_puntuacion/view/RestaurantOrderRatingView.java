package com.example.loginandroid_29_09_2023.restaurant_puntuacion.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.RestaurantePuntuacion;
import com.example.loginandroid_29_09_2023.restaurant_puntuacion.ContractRestaurantPuntuacion;
import com.example.loginandroid_29_09_2023.restaurant_puntuacion.presenter.RestaurantOrderRatingPresenter;
import com.example.loginandroid_29_09_2023.restaurant_ventas.view.LstProductsViewUser;

import java.util.ArrayList;

public class RestaurantOrderRatingView extends AppCompatActivity implements ContractRestaurantPuntuacion.View {

    public static RestaurantOrderRatingView mainActivity = null;

    private RecyclerView recyclerView;

    private RestaurantOrderRatingAdapter restaurantOrderRatingAdapter;

    private ImageButton volver;

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
        volver = findViewById(R.id.volver);
        volver.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(RestaurantOrderRatingView.this, LstProductsViewUser.class);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.recyclerView4);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        presenter.login();
    }


    @Override
    public void successLogin(ArrayList<RestaurantePuntuacion> lstRestaurantsPuntuacion) {
        this.lstRestaurantsPuntuacion = lstRestaurantsPuntuacion;
        initRecyclerView();

//        LinearLayout linearLayout = findViewById(R.id.lst_restaurants_rating);
//        for (RestaurantePuntuacion restaurantePuntuacion : lstRestaurantsPuntuacion) {
//            Restaurante restaurante = restaurantePuntuacion.getRestaurante();
//            TextView textView = new TextView(this);
//            textView.setText(restaurante.getNombre());
//            TextView textView2 = new TextView(this);
//           String prueba = String.valueOf(restaurantePuntuacion.getPuntuacion().getPuntuacion());
//            textView2.setText(prueba);
//            textView.setTextSize(20);
//            textView.setHeight(100);
//            textView2.setTextSize(20);
//            textView2.setHeight(100);
//            linearLayout.addView(textView);
//            linearLayout.addView(textView2);
//        }
    }
    private void initRecyclerView() {
        restaurantOrderRatingAdapter = new RestaurantOrderRatingAdapter(lstRestaurantsPuntuacion, this);
        if (restaurantOrderRatingAdapter != null && lstRestaurantsPuntuacion != null){
            recyclerView.setAdapter(restaurantOrderRatingAdapter);
        }
    }

    @Override
    public void failureLogin(String err) {

    }
}
