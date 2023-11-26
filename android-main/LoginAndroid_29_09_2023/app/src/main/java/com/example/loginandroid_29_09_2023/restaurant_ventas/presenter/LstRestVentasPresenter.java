package com.example.loginandroid_29_09_2023.restaurant_ventas.presenter;


import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.lst_products.ContractListMovies;
import com.example.loginandroid_29_09_2023.lst_products.model.LstProductsModel;
import com.example.loginandroid_29_09_2023.restaurant_ventas.ContractProductUser;
import com.example.loginandroid_29_09_2023.restaurant_ventas.model.RestaurantModel;

import java.util.ArrayList;

public class LstRestVentasPresenter implements ContractProductUser.Presenter,
                                        ContractProductUser.Model.OnLoginUserListener{

    private ContractProductUser.View vista;
    private RestaurantModel RestaurantModel;

    private ArrayList<ProductRestaurant> ProductoRestaurantes = new ArrayList<>();
   public LstRestVentasPresenter(ContractProductUser.View vista){
        this.vista = vista;
       RestaurantModel= new RestaurantModel(this);
   }
    @Override
    public void lstProductosRest(String filtro) {
        RestaurantModel.loginAPI("", this);
    }

    @Override
    public void onFinished(ArrayList<ProductRestaurant> lstRestVentasModel) {
        ProductoRestaurantes = lstRestVentasModel;
        vista.success(ProductoRestaurantes);
    }

    @Override
    public void onFailure(String err) {

    }



}
