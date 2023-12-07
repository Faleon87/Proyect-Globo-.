package com.example.loginandroid_29_09_2023.descripcion_restaurante.presenter;

import com.example.loginandroid_29_09_2023.beans.Restaurante;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.descripcion_restaurante.ContractDescripcionRest;
import com.example.loginandroid_29_09_2023.descripcion_restaurante.model.DescripcionRestaurantModel;
import com.example.loginandroid_29_09_2023.login_user.ContractLoginUser;

import java.util.ArrayList;

public class DescripcionRestaurantPresenter implements ContractDescripcionRest.Presenter, ContractDescripcionRest.Model.OnLoginUserListener {

    private ContractDescripcionRest.View view;
    private ContractDescripcionRest.Model model;

    public DescripcionRestaurantPresenter(ContractDescripcionRest.View view) {
        this.view = view;
        model = new DescripcionRestaurantModel(this);
    }



    @Override
    public void onFinished(Restaurante restaurante) {
        view.successLogin(restaurante);
    }

    @Override
    public void onFailure(String err) {

    }

    @Override
    public void login(Restaurante restaurante) {
        model.loginAPI(restaurante);
    }
}


