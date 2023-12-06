package com.example.loginandroid_29_09_2023.descripcion_restaurante.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.descripcion_restaurante.ContractDescripcionRest;
import com.example.loginandroid_29_09_2023.descripcion_restaurante.presenter.DescripcionRestaurantPresenter;
import com.example.loginandroid_29_09_2023.restaurant_puntuacion.view.RestaurantOrderRatingView;

public class DescripcionRestaurantView extends AppCompatActivity implements ContractDescripcionRest.View{

    private DescripcionRestaurantPresenter presenter =
            new DescripcionRestaurantPresenter(this);
    private static DescripcionRestaurantView mainActivity = null;

    private ImageButton volver3;

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
    }


    @Override
    public void successLogin(User user) {

    }

    @Override
    public void failureLogin(String err) {

    }
}

