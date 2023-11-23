package com.example.loginandroid_29_09_2023.lst_products.presenter;


import com.example.loginandroid_29_09_2023.beans.Productos;
import com.example.loginandroid_29_09_2023.lst_products.ContractListMovies;
import com.example.loginandroid_29_09_2023.lst_products.model.LstProductsModel;

import java.util.ArrayList;

public class LstProductsPresenter implements ContractListMovies.Presenter,
                                        ContractListMovies.Model.OnLstProductoListener{

    private ContractListMovies.View vista;
    private LstProductsModel lstMoviesModel;
    public LstProductsPresenter(ContractListMovies.View vista){
        this.vista = vista;
        lstMoviesModel = new LstProductsModel(this);
    }
    @Override
    public void lstMovies(String filtro) {
        lstMoviesModel.moviesAPI("", this);
    }

    @Override
    public void onFinished(ArrayList<Productos> lstProductos) {
        vista.successMovies(lstProductos);
    }

    @Override
    public void onFailure(String err) {

    }
}
