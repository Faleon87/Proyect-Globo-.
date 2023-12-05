package com.example.loginandroid_29_09_2023.descripcion_restaurante.presenter;

import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.descripcion_restaurante.ContractDescripcionRest;
import com.example.loginandroid_29_09_2023.descripcion_restaurante.model.DescripcionRestaurantModel;

public class DescripcionRestaurantPresenter implements ContractDescripcionRest.Presenter, ContractDescripcionRest.Model.OnLoginUserListener {

    private ContractDescripcionRest.View view;
    private ContractDescripcionRest.Model model;

    public DescripcionRestaurantPresenter(ContractDescripcionRest.View view) {
        this.view = view;
        model = new DescripcionRestaurantModel(this);
    }

    @Override
    public void login(User user) {

    }

    @Override
    public void onFinished(User user) {

    }

    @Override
    public void onFailure(String err) {

    }

}


