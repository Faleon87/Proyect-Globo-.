package com.example.loginandroid_29_09_2023.Parte_admin.presenter;


import com.example.loginandroid_29_09_2023.Parte_admin.ContractAdmin;
import com.example.loginandroid_29_09_2023.Parte_admin.model.AdminModel;
import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.lst_products.ContractListMovies;
import com.example.loginandroid_29_09_2023.lst_products.model.LstProductsModel;

import java.util.ArrayList;

public class LstPAdminPresenter implements ContractAdmin.Presenter,
                                        ContractAdmin.Model.OnLoginUserListener{

    private ContractListMovies.View vista;
    private AdminModel adminModel;

    private ArrayList<ProductRestaurant> ProductoRestaurantes = new ArrayList<>();
    public LstPAdminPresenter(ContractAdmin.View vista){
        this.vista = (ContractListMovies.View) vista;
        adminModel = new AdminModel(this);
    }

    @Override
    public void onFinished(User user) {

    }

    @Override
    public void onFailure(String err) {

    }


}
