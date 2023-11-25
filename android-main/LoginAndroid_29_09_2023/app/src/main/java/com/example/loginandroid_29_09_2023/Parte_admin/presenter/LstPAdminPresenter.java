package com.example.loginandroid_29_09_2023.Parte_admin.presenter;


import com.example.loginandroid_29_09_2023.Parte_admin.ContractAdmin;
import com.example.loginandroid_29_09_2023.Parte_admin.model.AdminModel;
import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.lst_products.ContractListMovies;

import java.util.ArrayList;

public class LstPAdminPresenter implements ContractAdmin.Presenter,
                                        ContractAdmin.Model.OnLoginUserListener{

    private ContractAdmin.View view;
    private ContractAdmin.Model adminModel;

    private ArrayList<ProductRestaurant> ProductoRestaurantes = new ArrayList<>();
    public LstPAdminPresenter(ContractAdmin.View view){
        this.view = view;
        adminModel = new AdminModel(this);
    }


    @Override
    public void onFinished(ArrayList<ProductRestaurant> user) {

    }

    @Override
    public void onFailure(String err) {

    }


    @Override
    public void login(ProductRestaurant infopr) {
        adminModel.loginAPI(infopr, this);
    }


}
