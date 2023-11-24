package com.example.loginandroid_29_09_2023.lst_products.presenter;


import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.lst_products.ContractListMovies;
import com.example.loginandroid_29_09_2023.lst_products.model.LstProductsModel;

import java.util.ArrayList;

public class LstProductsPresenter implements ContractListMovies.Presenter,
                                        ContractListMovies.Model.OnLstProductoListener{

    private ContractListMovies.View vista;
    private LstProductsModel lstProductsModel;

    private ArrayList<ProductRestaurant> ProductoRestaurantes = new ArrayList<>();
    public LstProductsPresenter(ContractListMovies.View vista){
        this.vista = vista;
        lstProductsModel = new LstProductsModel(this);
    }
    @Override
    public void lstProductos(String filtro) {
        lstProductsModel.moviesAPI("", this);
    }




    @Override
    public void onFinished(ArrayList<ProductRestaurant> lstProductos) {
        ProductoRestaurantes = lstProductos;
        vista.successMovies(ProductoRestaurantes);
    }

    @Override
    public void onFailure(String err) {

    }
}
