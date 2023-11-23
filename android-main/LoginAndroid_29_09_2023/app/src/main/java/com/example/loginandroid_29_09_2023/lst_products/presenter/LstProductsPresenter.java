package com.example.loginandroid_29_09_2023.lst_products.presenter;

import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.lst_products.ContractListMovies;
import com.example.loginandroid_29_09_2023.lst_products.model.LstProductsModel;

import java.util.ArrayList;

public class LstProductsPresenter implements ContractListMovies.Presenter,
                                        ContractListMovies.Model.OnLstMoviesListener{

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
    public void onFinished(ArrayList<Producto> lstPelicula) {
        vista.successMovies(lstPelicula);
    }

    @Override
    public void onFailure(String err) {

    }
}
