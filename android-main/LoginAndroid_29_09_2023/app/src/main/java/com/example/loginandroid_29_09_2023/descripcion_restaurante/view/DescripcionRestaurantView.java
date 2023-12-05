package com.example.loginandroid_29_09_2023.descripcion_restaurante.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.descripcion_restaurante.ContractDescripcionRest;
import com.example.loginandroid_29_09_2023.descripcion_restaurante.presenter.DescripcionRestaurantPresenter;

public class DescripcionRestaurantView extends AppCompatActivity implements ContractDescripcionRest.View{

    private DescripcionRestaurantPresenter presenter =
            new DescripcionRestaurantPresenter(this);
    private static DescripcionRestaurantView mainActivity = null;

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

    }


    @Override
    public void successLogin(User user) {

    }

    @Override
    public void failureLogin(String err) {

    }
}

